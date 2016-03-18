package net.mizofumi.chinachu4j;

import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Authenticator;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

/**
 * Created by mizofumi on 2016/03/18.
 */
public class ChinachuHttp {

    BasicAuthenticator basicAuthenticator;

    public ChinachuHttp(BasicAuthenticator basicAuthenticator) {
        this.basicAuthenticator = basicAuthenticator;
    }

    public String getServer(String url) throws NoSuchAlgorithmException, KeyManagementException, IOException {
        boolean isSSL = url.startsWith("https://");

        SSLContext sslcontext = null;
        if(isSSL) {
            TrustManager[] tm = {new X509TrustManager(){
                @Override
                public X509Certificate[] getAcceptedIssuers(){
                    return null;
                }

                @Override
                public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
                }

                @Override
                public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException{
                }
            }};
            sslcontext = SSLContext.getInstance("SSL");
            sslcontext.init(null, tm, null);

            HttpsURLConnection.setDefaultHostnameVerifier(new HostnameVerifier() {
                @Override
                public boolean verify(String hostname, SSLSession session) {
                    return true;
                }
            });
        }

        URL connectUrl = new URL(url);
        InputStream is;
        HttpURLConnection http = null;
        HttpsURLConnection https = null;
        if (basicAuthenticator != null)
            Authenticator.setDefault(basicAuthenticator);
        if(isSSL) {
            https = (HttpsURLConnection)connectUrl.openConnection();
            https.setRequestMethod("GET");
            https.setSSLSocketFactory(sslcontext.getSocketFactory());
            https.connect();
            is = https.getInputStream();
        }else{
            http = (HttpURLConnection)connectUrl.openConnection();
            http.setRequestMethod("GET");
            http.connect();
            is = http.getInputStream();
        }

        BufferedReader reader = new BufferedReader(new InputStreamReader(is, "utf8"));
        String line;
        StringBuilder sb = new StringBuilder();
        while((line = reader.readLine()) != null){
            sb.append(line);
        }
        reader.close();
        if(isSSL)
            https.disconnect();
        else
            http.disconnect();
        is.close();
        return sb.toString();
    }

    public ChinachuResponse postServer(String url,String json)throws NoSuchAlgorithmException,KeyManagementException,IOException{
        boolean isSSL = url.startsWith("https://");

        SSLContext sslcontext = null;
        if(isSSL) {
            TrustManager[] tm = {new X509TrustManager(){
                @Override
                public X509Certificate[] getAcceptedIssuers(){
                    return null;
                }

                @Override
                public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
                }

                @Override
                public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException{
                }
            }};
            sslcontext = SSLContext.getInstance("SSL");
            sslcontext.init(null, tm, null);

            HttpsURLConnection.setDefaultHostnameVerifier(new HostnameVerifier(){
                @Override
                public boolean verify(String hostname, SSLSession session){
                    return true;
                }
            });
        }

        URL connectUrl = new URL(url);
        OutputStream os;
        HttpURLConnection http = null;
        HttpsURLConnection https = null;
        if (basicAuthenticator != null)
            Authenticator.setDefault(basicAuthenticator);
        if(isSSL) {
            https = (HttpsURLConnection)connectUrl.openConnection();
            https.setRequestMethod("POST");
            https.setRequestProperty("Content-Type", "application/json");
            https.setSSLSocketFactory(sslcontext.getSocketFactory());
            https.connect();
            os = https.getOutputStream();
        }else{
            http = (HttpURLConnection)connectUrl.openConnection();
            http.setRequestMethod("POST");
            http.setRequestProperty("Content-Type", "application/json");
            http.connect();
            os = http.getOutputStream();
        }
        OutputStreamWriter osw = new OutputStreamWriter(os, "UTF-8");
        osw.write(json);
        osw.flush();
        osw.close();
        os.close();

        ChinachuResponse response;
        if(isSSL){
            response = new ChinachuResponse(https.getResponseCode());
            https.disconnect();
        }else{
            response = new ChinachuResponse(http.getResponseCode());
            http.disconnect();
        }
        return response;
    }

    public ChinachuResponse putWithJsonServer(String url,String json) throws NoSuchAlgorithmException,KeyManagementException,IOException{
        boolean isSSL = url.startsWith("https://");

        SSLContext sslcontext = null;
        if(isSSL) {
            TrustManager[] tm = {new X509TrustManager(){
                @Override
                public X509Certificate[] getAcceptedIssuers(){
                    return null;
                }

                @Override
                public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
                }

                @Override
                public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException{
                }
            }};
            sslcontext = SSLContext.getInstance("SSL");
            sslcontext.init(null, tm, null);

            HttpsURLConnection.setDefaultHostnameVerifier(new HostnameVerifier(){
                @Override
                public boolean verify(String hostname, SSLSession session){
                    return true;
                }
            });
        }

        URL connectUrl = new URL(url);
        OutputStream os;
        HttpURLConnection http = null;
        HttpsURLConnection https = null;
        if (basicAuthenticator != null)
            Authenticator.setDefault(basicAuthenticator);
        if(isSSL) {
            https = (HttpsURLConnection)connectUrl.openConnection();
            https.setRequestMethod("PUT");
            https.setRequestProperty("Content-Type", "application/json");
            https.setSSLSocketFactory(sslcontext.getSocketFactory());
            https.connect();
            os = https.getOutputStream();
        }else{
            http = (HttpURLConnection)connectUrl.openConnection();
            http.setRequestMethod("PUT");
            http.setRequestProperty("Content-Type", "application/json");
            http.connect();
            os = http.getOutputStream();
        }
        OutputStreamWriter osw = new OutputStreamWriter(os, "UTF-8");
        osw.write(json);
        osw.flush();
        osw.close();
        os.close();

        ChinachuResponse response;
        if(isSSL){
            response = new ChinachuResponse(https.getResponseCode());
            https.disconnect();
        }else{
            response = new ChinachuResponse(http.getResponseCode());
            http.disconnect();
        }
        return response;
    }
}
