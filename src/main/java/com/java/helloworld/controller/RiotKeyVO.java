package com.java.helloworld.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicHeader;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;

public class RiotKeyVO {
	private static String BaseURL ;
	private static Header Charset;
	private static Header RiotKey;
	private static String response_string;
	private static String Riot;
	HttpClient httpclient = HttpClientBuilder.create().build();
	RiotKeyVO(){
		BaseURL = "https://kr.api.riotgames.com/lol/";
		Riot = "RGAPI-624b7171-b654-4d7f-8985-f72eb1409683";
	}
	public String ChampionCall() throws  ClassNotFoundException{
		String ChampionURL = "champion-mastery/v3/champion-masteries/by-summoner/";
		String SummonerId = "6082734"; //param필요
		HttpGet ChampionGet = new HttpGet(BaseURL + ChampionURL + SummonerId);
		Send(ChampionGet);
		return response_string;			
	}
	public String GetID() throws  ClassNotFoundException{
		Long ID = null;
		String Name = null;
		String SummonerNameURL = "summoner/v3/summoners/by-name/";
		String SummonerName = "회로가주거씀돠엉"; //param필요
		HttpGet SummonerGet = new HttpGet(BaseURL + SummonerNameURL + SummonerName);
		Send(SummonerGet);
		
		/*try {
			response = httpclient.execute(SummonerGet);
			int statusCode = response.getStatusLine().getStatusCode();
			String message = response.getStatusLine().getReasonPhrase();
			if (statusCode == 200) {
                response_string = EntityUtils.toString(response.getEntity());
                JSONObject json = new JSONObject(response_string);
                System.out.println(json);
                ID = json.getLong("id");
                Name = json.getString("name");          
                
                System.out.println(""+Name+"의 ID는 " +ID + " 입니다.");                
            } else {
                System.out.println("Status code returned is " + statusCode);
                System.out.println("An error has occured. Http status: " + message);
            }
		}*/
		return response_string;
			
	}
	public String SpectorCall() throws  ClassNotFoundException{
		String SpectorURL = "spectator/v3/active-games/by-summoner/";
		String SummonerId = "2221546"; //param필요
		HttpGet SpectorGet = new HttpGet(BaseURL + SpectorURL + SummonerId);
		Send(SpectorGet);
		return response_string;			
	}
	public String MatchCall() throws  ClassNotFoundException{		
		String MatchURL = "match/v3/matchlists/by-account";
		String SummonerId = "6082734"; //param필요
		HttpGet MatchGet = new HttpGet(BaseURL + MatchURL + SummonerId);
		Send(MatchGet);		
		return response_string;			
	}
	public void Send(HttpGet Get) throws  ClassNotFoundException{
		Charset = new BasicHeader("Accept-Charset", "application/x-www-form-urlencoded; charset=UTF-8");
		RiotKey = new BasicHeader("X-Riot-Token",Riot); //	
		Get.addHeader(Charset);
		Get.addHeader(RiotKey);
		HttpResponse response = null;		
		try {
			response = httpclient.execute(Get);
			int statusCode = response.getStatusLine().getStatusCode();
			String message = response.getStatusLine().getReasonPhrase();
			if (statusCode == 200) {
                response_string = EntityUtils.toString(response.getEntity());                
            } else {
                System.out.println("Status code returned is " + statusCode);
                System.out.println("An error has occured. Http status: " + message);
                response_string = "This is Error";
            }
		}
		catch(ClientProtocolException cpException) {
			cpException.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
