package co.com.davivienda.utils;

import co.com.davivienda.models.InfoEmpleado;
import co.com.davivienda.models.JobTitle;
import co.com.davivienda.models.Location;
import co.com.davivienda.models.Subnit;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.List;

public class TransformarJsons {

    public static List<InfoEmpleado> transformarJsonAListaEmpleados(JSONArray jsonArray) {
        JSONObject empleadoJson;
        List<InfoEmpleado> listaEmpleados = new java.util.ArrayList<>();
        for (int i=0; i < jsonArray.size(); i++) {
            InfoEmpleado empleado = new InfoEmpleado();
            empleadoJson = (JSONObject) jsonArray.get(i);
            empleado.setEmpNumber(empleadoJson.get("empNumber") != null ? empleadoJson.get("empNumber").toString() : "");
            empleado.setFirstName(empleadoJson.get("firstName") != null ? empleadoJson.get("firstName").toString() : "");
            empleado.setLastName(empleadoJson.get("lastName") != null ? empleadoJson.get("lastName").toString() : "");
            empleado.setMiddleName(empleadoJson.get("middleName") != null ? empleadoJson.get("middleName").toString() : "");
            empleado.setTerminationId(empleadoJson.get("terminationId") != null ? empleadoJson.get("terminationId").toString() : "");
            empleado.setJobTitle(transformarJsonATituloTrabajo((JSONObject) empleadoJson.get("jobTitle")));
            empleado.setSubnit(transformarJsonASubnit((JSONObject) empleadoJson.get("subunit")));
            empleado.setLocation(transformarJsonALocation((JSONObject) empleadoJson.get("location")));
            listaEmpleados.add(empleado);
        }
        return listaEmpleados;
    }

    public static JobTitle transformarJsonATituloTrabajo(JSONObject jsonObject) {
        JobTitle jobTitle = new JobTitle();
        jobTitle.setId(jsonObject.get("id") != null ? jsonObject.get("id").toString() : "");
        jobTitle.setTitle(jsonObject.get("title") != null ? jsonObject.get("title").toString() : "");
        jobTitle.setIsDelete(jsonObject.get("isDeleted") != null ? jsonObject.get("isDeleted").toString() : "");
        return jobTitle;
    }

    public static Subnit transformarJsonASubnit(JSONObject jsonObject) {
        Subnit subnit = new Subnit();
        subnit.setId(jsonObject.get("id") != null ? jsonObject.get("id").toString() : "");
        subnit.setName(jsonObject.get("name") != null ? jsonObject.get("name").toString() : "");
        return subnit;
    }

    public static Location transformarJsonALocation(JSONObject jsonObject) {
        Location location = new Location();
        location.setId(jsonObject.get("id") != null ? jsonObject.get("id").toString() : "");
        location.setName(jsonObject.get("name") != null ? jsonObject.get("name").toString() : "");
        return location;
    }
}
