package com.esri.a4iot;

import io.swagger.model.ModelApiResponse;
import io.swagger.model.Tenant;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;


public class TenantImpl {


    private String scriptFolder;

    private String deleteTenant;
    private String createTenant;
    private String updateTenant;

    private String sep = System.getProperty("file.separator");
    private String nl = System.getProperty("line.separator");

    public TenantImpl() {

        try {

            // Load Script Folder
            Properties prop = new Properties();
            InputStream in = getClass().getClassLoader().getResourceAsStream("main.properties");
            prop.load(in);

            scriptFolder = prop.getProperty("scriptFolder");
            in.close();

            //System.out.println("scriptFolder:" + scriptFolder);


            // Load Script Vars
            in = getClass().getClassLoader().getResourceAsStream(this.getClass().getSimpleName() + ".properties");
            prop.load(in);

            deleteTenant = prop.getProperty("deleteTenant");

            createTenant = prop.getProperty("createTenant");

            updateTenant = prop.getProperty("updateTenant");

            // Printout the Scripts
            //System.out.println("deleteTenant:" + deleteTenant);
            //System.out.println("createTenant:" + createTenant);
            //System.out.println("updateTenant:" + updateTenant);


        } catch (IOException e) {
            // Need to return error to rest client....
            e.printStackTrace();
        }

    }

    public ModelApiResponse create(String tenantID, Tenant body) {
        ModelApiResponse resp = new ModelApiResponse();

        String location = body.getLocation().toString();
        String a4ioBuildNum = body.getA4iotBuildNum();
        String azureCoresPerInstance = body.getAzureCoresPerInstance().toString();
        Integer azureNumInstance = body.getAzureNumInstances();

        resp.setCode(0);
        resp.setMessage("Create started; use get to check status");
        resp.setType("Started");

        // Create tenants and tenant folder if needed
        Path path = Paths.get(scriptFolder + sep + "tenants");
        try {
            if (!Files.exists(path)) {
                Files.createDirectories(path);
            }
            path = Paths.get(scriptFolder + sep + "tenants" + sep + tenantID);
            if (Files.exists(path)) {
                resp.setCode(99);
                resp.setMessage("Tenant Already Exists");
                resp.setType("Create Failed");

                return resp;

            } else {
                // Create Tenant Folder
                Files.createDirectories(path);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        String cmd = scriptFolder + sep + createTenant + " " + tenantID + " "
                + a4ioBuildNum + " " + location + " "
                + azureCoresPerInstance + " " + azureNumInstance
                + " > " + scriptFolder + sep + "tenants" + sep + tenantID + sep + "create.log";

        System.out.println("Running command: " + cmd);

        Process process = null;

        try {
            process = executeScript(cmd);
        } catch (InterruptedException | IOException e) {
            resp.setCode(1);
            resp.setMessage("Create failed");
            resp.setType("Failed");

            if (process != null) {
                try {
                    System.out.println(output(process.getInputStream()));
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            }

            e.printStackTrace();

        }



        return resp;
    }

    public ModelApiResponse delete(String tenantID, String confirm) {
        ModelApiResponse resp = new ModelApiResponse();


        // Create tenants and tenant folder if needed
        Path path = Paths.get(scriptFolder + sep + "tenants" + sep + tenantID);
        try {
            if (!Files.exists(path)) {
                resp.setCode(99);
                resp.setMessage("Tenant Does Not Exist");
                resp.setType("Delete Failed");
                return resp;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        resp.setCode(0);
        resp.setMessage("Delete started; use get to check status");

        // TO DO: Implement code for confirm
        /*
            User would need to call delete twice.
            First time to create a confirm code; second time with code to start delete
         */

        String cmd = scriptFolder + sep + deleteTenant + " " + tenantID
                + " > " + scriptFolder + sep + "tenants" + sep + tenantID + sep + "delete.log";

        System.out.println("Running command: " + cmd);

        Process process = null;

        try {
            process = executeScript(cmd);
        } catch (InterruptedException | IOException e) {
            resp.setCode(1);
            resp.setMessage("Delete failed");
            resp.setType("Failed");

            if (process != null) {
                try {
                    System.out.println(output(process.getInputStream()));
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            }

            e.printStackTrace();


        }

        return resp;
    }

    public ModelApiResponse get(String tenantID) {

        ModelApiResponse resp = new ModelApiResponse();

        // Create tenants and tenant folder if needed
        Path path = Paths.get(scriptFolder + sep + "tenants" + sep + tenantID);
        try {
            if (!Files.exists(path)) {
                resp.setCode(99);
                resp.setMessage("Tenant Does Not Exist");
                resp.setType("Delete Failed");
                return resp;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        Integer code = 0;

        // Read contents of scriptFolder/tenants/tenantID/log into Message
        StringBuilder logSB = new StringBuilder();
        String log;
        try {
            BufferedReader br = new BufferedReader(new FileReader(scriptFolder
                    + sep + "tenants" + sep + tenantID + sep + "log"));

            String line;
            while ((line = br.readLine()) != null) {
                logSB.append(line + "\n");
            }
            log = logSB.toString();

        } catch (IOException e) {
            log = "Error reading log file";
            code = 1;
            e.printStackTrace();
        }

        // Read contents of scriptFolder/tenants/tenantID/status into Type
        String status;
        try {
            BufferedReader br = new BufferedReader(new FileReader(scriptFolder
                    + sep +  "tenants" + sep + tenantID + sep + "status"));
            status = br.readLine();

        } catch (IOException e) {
            status = "Error reading log file";
            code = 2;
            e.printStackTrace();
        }

        resp.setMessage(log);
        resp.setType(status);
        resp.setCode(code);

        //System.out.println(log);
        //System.out.println(status);
        return resp;
    }

    public ModelApiResponse update(String tenantID, String a4ioBuildNum) {
        ModelApiResponse resp = new ModelApiResponse();

        resp.setCode(0);
        resp.setMessage("Update started; use get to check status");
        resp.setType("Started");

        String cmd = scriptFolder + sep + updateTenant + " " + tenantID
                + " " + a4ioBuildNum
                + " > " + scriptFolder + sep + "tenants" + sep + tenantID + sep + "update.log";;

        System.out.println("Running command: " + cmd);

        Process process = null;

        try {
            process = executeScript(cmd);
        } catch (InterruptedException | IOException e) {
            resp.setCode(1);
            resp.setMessage("Delete failed");
            resp.setType("Failed");

            if (process != null) {
                try {
                    System.out.println(output(process.getInputStream()));
                } catch (IOException e2) {
                    e2.printStackTrace();
                }

            }

            e.printStackTrace();
        }

        return resp;
    }

//
//    public static void main(String args[]) {
//        TenantImpl t = new TenantImpl();
//        String tenantID = "dj1111";
//        t.get(tenantID);
//        //t.update("dj1111", "latest");
//    }

    private String output(InputStream inputStream) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader
                br = null;
        try {
            br = new BufferedReader(new InputStreamReader(inputStream));
            String line = null;
            while ((line = br.readLine()) != null) {
                sb.append(line + nl);
            }
        } finally {
            br.close();
        }
        return sb.toString();
    }

    private Process executeScript(String cmd) throws InterruptedException, IOException {
        // Log the command
        System.out.println(cmd);

        ProcessBuilder pb = new ProcessBuilder("bash", "-c", cmd);
        pb.directory(new File(scriptFolder));
        Process process = pb.start();

        return process;

    }




}
