package com.mycompany.jerseysem3;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

//http://127.0.0.1:49000/api/convert/

@Path("/convert")
public class ConverterAPI {
    
    // Please run this class and paste the below URL into your browser. 
    // http://127.0.0.1:49000/api/convert/numeraltoroman/20
    // Curl command: curl -vi -X GET -G "http://127.0.0.1:49000/api/convert/numeraltoroman/20"

    @GET
    @Path("numeraltoroman/{param}")
    public Response numeralToRoman(@PathParam("param") int input) {
        
        // Create NumeralToRoman object and pass in the 'input' from API.
        // Convert 'input' and store conversion as 'output'.
        NumeralToRoman numberToRoman = new NumeralToRoman(input);
        String output = numberToRoman.convertNumeralToRoman();
        String message = "Number entered: " + input + "<BR> Roman numeral equivilant: " + output;
        return Response.status(200).entity(message).build();
    }
    
    //Please run this class and paste the below URL into your browser.
    //http://127.0.0.1:49000/api/convert/romantonumeral/m
    // Curl command: curl -vi -X GET -G "http://127.0.0.1:49000/api/convert/romantonumeral/xx"
    
    @GET
    @Path("romantonumeral/{param}")
    public Response romanToNumeral(@PathParam("param") String input) {
       
        // Create RomanToNumeral object and pass in the 'input' from API.
        // Convert 'input' and store conversion as 'output'.
        RomanToNumeral romanToNumeral = new RomanToNumeral(input);
        int output = romanToNumeral.convertRomanToNumber();
        String message = "Roman numeral entered: " + input + "<BR> Number equivilant: " + output;
        return Response.status(200).entity(message).build();
    }
}
