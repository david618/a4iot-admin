package com.esri.a4iot;

import io.swagger.model.TenantStatus;
import io.swagger.model.Tenants;

import java.io.*;
import java.util.Properties;

public class TenantsImpl {

    private String scriptFolder;

    private String sep = System.getProperty("file.separator");

    public TenantsImpl() {

        try {

            // Load Script Folder
            Properties prop = new Properties();
            InputStream in = getClass().getClassLoader().getResourceAsStream("main.properties");
            prop.load(in);

            scriptFolder = prop.getProperty("scriptFolder");
            in.close();

            //System.out.println("scriptFolder:" + scriptFolder);
        } catch (IOException e) {
            // Need to return error to rest client....
            e.printStackTrace();
        }

    }

    public Tenants get() {

        Tenants resp = new Tenants();

        File folder = new File(scriptFolder + sep + "tenants");
        File[] listOfFiles = folder.listFiles();

        for (File tf : listOfFiles) {
            String tenantId = tf.getName();
            String status;
            try {
                BufferedReader br = new BufferedReader(new FileReader(scriptFolder
                        + sep +  "tenants" + sep + tenantId + sep + "status"));
                status = br.readLine();

            } catch (IOException e) {
                status = "Error reading status file";
                e.printStackTrace();
            }
            //System.out.println(tenantId + " : " + status);
            TenantStatus t = new TenantStatus();
            t.setStatus(status);
            t.setTenantId(tenantId);

            resp.add(t);
        }



        return resp;
    }

    public static void main(String args[]) {

        TenantsImpl t = new TenantsImpl();
        Tenants tenants = t.get();
        for (TenantStatus ts : tenants) {
           System.out.println(ts.getTenantId() + " : " + ts.getStatus());
        }

    }
}
