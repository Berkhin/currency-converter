package telran.converter.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.annotation.JsonProperty.Access;

import telran.converter.dto.ConverterDto;

public class ConverterAppl {

    public static void main(String[] args) throws URISyntaxException, IOException {

	RestTemplate restTenplate = new RestTemplate();
	String url = "http://data.fixer.io/api/latest";
	UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url)
		.queryParam("accrss_key", "120c8f75b00e7ab91da9008a737ccd6d")
		.queryParam("symbols", "usd, eur, blr, rub, uah, byn");
	RequestEntity<String> requestEntity = new RequestEntity<>(HttpMethod.GET, builder.build().toUri());
	ResponseEntity<ConverterDto> responseEntity = restTenplate.exchange(requestEntity,
		new ParameterizedTypeReference<ConverterDto>() {
		});

	BufferedReader readerFrom = new BufferedReader(new InputStreamReader(System.in));
	System.out.print("Enter from currency: ");
	String from = readerFrom.readLine();
	BufferedReader readerTo = new BufferedReader(new InputStreamReader(System.in));
	System.out.print("Enter to currency: ");
	String to = readerTo.readLine();
	BufferedReader readerCount = new BufferedReader(new InputStreamReader(System.in));
	System.out.print("Enter count currency: ");
	String count = readerCount.readLine();
	System.out.println((responseEntity.getBody().getRates().get(to) / responseEntity.getBody().getRates().get(from))
		* Integer.parseInt(count));

    }

}
