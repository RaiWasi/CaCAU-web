package com.airbus.alten.cacau.security;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Authenticator;
import java.net.HttpURLConnection;
import java.net.PasswordAuthentication;
import java.net.URL;

public class NtlmFeature {

	private final static String USER = "NG6629C";
	private final static String PASSWORD = ""; //mein neuer pass
	private final static String DOMAIN = "de0-vsiaas-1345.eu.airbus.corp";

	public String getAuthenticatedResponse(final String API_URL) throws IOException {

		StringBuilder response = new StringBuilder();

		Authenticator.setDefault(new Authenticator() {
			@Override
			public PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(DOMAIN + "\\" + USER, PASSWORD.toCharArray());
			}
		});

		URL urlRequest = new URL(API_URL);
		HttpURLConnection conn = (HttpURLConnection) urlRequest.openConnection();
		conn.setDoOutput(true);
		conn.setDoInput(true);
		conn.setRequestMethod("GET");

		InputStream stream = conn.getInputStream();
		BufferedReader in = new BufferedReader(new InputStreamReader(stream));
		String str = "";
		while ((str = in.readLine()) != null) {
			response.append(str);
		}
		in.close();

		return response.toString();
	}
}
