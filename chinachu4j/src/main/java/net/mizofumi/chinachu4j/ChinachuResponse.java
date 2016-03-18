package net.mizofumi.chinachu4j;

/**
 * Created by mizofumi on 2016/03/18.
 */
public class ChinachuResponse {

    private int responseCode;
    private String message;
    private boolean result;

    public ChinachuResponse(int responseCode){
        this.responseCode = responseCode;
        result = false;
        setMessage();
    }

    private void setMessage(){

        switch(responseCode){
            case 200:
                message = "Request was successful. It has been successfully processed.";
                result = true;
                break;
            case 201:
                message = "Request is complete. It has been created.";
                result = true;
                break;
            case 202:
                message = "Request has been accepted. Processing continues.";
                result = true;
                break;
            case 400:
                message = "Invalid request.";
                break;
            case 401:
                message = "Authentication is required.";
                break;
            case 403:
                message = "Request execution was rejected .";
                break;
            case 404:
                message = "The requested API or resource was not found.";
                break;
            case 405:
                message = "Method not allowed.";
                break;
            case 409:
                message = "Request conflict.";
                break;
            case 410:
                message = "Resources are now missing.";
                break;
            case 415:
                message = "The specified response format might not be valid.";
                break;
            case 500:
                message = "Internal server error";
                break;
            case 501:
                message = "Not Implemented";
                break;
            case 503:
                message = "Service Unavailable";
                break;
            default:
                message = "Unknown error has occurred.";
                break;
        }
    }

    public int getResponseCode(){
        return responseCode;
    }

    public String getMessage(){
        return message;
    }

    public boolean getResult(){
        return result;
    }

}
