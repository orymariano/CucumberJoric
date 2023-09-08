package Utils;

import org.json.JSONObject;

public class APIPayloadConstants {

    public static String createEmployeePayload() {
        String createEmployeePayload = "{\n" +
                "    \"emp_firstname\": \"Trafalgar\",\n" +
                "    \"emp_lastname\": \"Law\",\n" +
                "    \"emp_middle_name\": \"D\",\n" +
                "    \"emp_gender\": \"M\",\n" +
                "    \"emp_birthday\": \"2023-08-08\",\n" +
                "    \"emp_status\": \"Confirmed\",\n" +
                "    \"emp_job_title\": \"Doctor\"\n" +
                "}";

        return createEmployeePayload;
    }

    public static String createEmployeePayLoadJson() {

        JSONObject obj = new JSONObject();
        obj.put("emp_firstname", "Trafalgar");
        obj.put("emp_lastname", "Law");
        obj.put("emp_middle_name", "D");
        obj.put("emp_gender", "M");
        obj.put("emp_birthday", "2023-08-08");
        obj.put("emp_status", "Confirmed");
        obj.put("emp_job_title", "doctor");
        return obj.toString();
    }

    public static String createEmployeePayloadDynamic(
            String emp_firstname, String emp_lastname, String emp_middle_name,
            String emp_gender, String emp_birthday, String emp_status, String emp_job_title) {
        JSONObject obj = new JSONObject();
        obj.put("emp_firstname", emp_firstname);
        obj.put("emp_lastname", emp_lastname);
        obj.put("emp_middle_name", emp_middle_name);
        obj.put("emp_gender", emp_gender);
        obj.put("emp_birthday", emp_birthday);
        obj.put("emp_status", emp_status);
        obj.put("emp_job_title", emp_job_title);
        return obj.toString();
    }

    public static String updateEmployeePayLoadJson() {
        JSONObject obj = new JSONObject();
        obj.put("employee_id","57564A");
        obj.put("emp_firstname", "Monkey");
        obj.put("emp_lastname", "Luffy");
        obj.put("emp_middle_name", "D");
        obj.put("emp_gender", "M");
        obj.put("emp_birthday", "2023-01-01");
        obj.put("emp_status", "Confirmed");
        obj.put("emp_job_title", "Pirate King");
        return obj.toString();
    }
}

