package com.java.helloworld.controller;

import java.io.IOException;
import java.util.Date;
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
	private static Long SummonerId;
	private static Long AccountId;
	HttpClient httpclient = HttpClientBuilder.create().build();
	RiotKeyVO(){
		BaseURL = "https://kr.api.riotgames.com/lol/";
		Riot = "RGAPI-359ea26e-609c-4be9-9b9c-0da2d2685194";
	}
	public String SummonerCall() throws  ClassNotFoundException{
		String ChampionURL = "champion-mastery/v3/champion-masteries/by-summoner/";
		String SummonerId = "6082734";
		HttpGet ChampionGet = new HttpGet(BaseURL + ChampionURL + SummonerId);
		Send(ChampionGet);
		//System.out.print(response_string);
		//JSONObject json = new JSONObject(response_string);
		//System.out.println(json.get);
		return response_string;			
	}
	public String GetID(String SummonerName) throws  ClassNotFoundException{
		String SummonerNameURL = "summoner/v3/summoners/by-name/";
		HttpGet SummonerGet = new HttpGet(BaseURL + SummonerNameURL + SummonerName);
		Send(SummonerGet);
		
		JSONObject json = new JSONObject(response_string);
		SummonerId = json.getLong("id");
		AccountId = json.getLong("accountId");
		System.out.println("소환사 이름 : " + SummonerName + " 소환사 레벨 : " + json.getLong("summonerLevel") + " AccountID : " + AccountId + " Summoer " + SummonerId); 
		
		return response_string;
	}
	public String SpectorCall() throws  ClassNotFoundException{
		String SpectorURL = "spectator/v3/active-games/by-summoner/";
		HttpGet SpectorGet = new HttpGet(BaseURL + SpectorURL + SummonerId);
		//System.out.println(SummonerId);
		if(Send(SpectorGet) == 1)
			return response_string;	
		
		System.out.println(response_string);		
		JSONObject json = new JSONObject(response_string);
		JSONArray j = json.getJSONArray("participants");
		Long GameStartTime = json.getLong("gameStartTime");
		String GameMode = json.getString("gameMode");
		String GameType = json.getString("gameType");
		
		String SummonerName;
		Long Champion;
		//JSONObject Perks = null;
		Long Perks;
		Long Spell1;
		Long Spell2;
		Long Team;
		System.out.println("게임 시간  " + GameStartTime + " 게임 모드 " + GameMode + "게임 타입 " + GameType);
		for (int i = 0; i <  j.length(); i++){
            SummonerName = json.getJSONArray("participants").getJSONObject(i).getString("summonerName");
            Champion = json.getJSONArray("participants").getJSONObject(i).getLong("championId");
            Perks = json.getJSONArray("participants").getJSONObject(i).getJSONObject("perks").getLong("perkStyle");
            Spell2 = json.getJSONArray("participants").getJSONObject(i).getLong("spell2Id");
            Spell1 = json.getJSONArray("participants").getJSONObject(i).getLong("spell1Id");
            Team = json.getJSONArray("participants").getJSONObject(i).getLong("teamId");
            if(Team == 100)  Team = (long) 1;
            else if(Team == 200) Team = (long) 2;
            System.out.println(Team + "Team : " + "소환사 이름 " + SummonerName + " 챔피언 : " + Champion + " 특성 : " + Perks +  " 1스펠 " + Spell1 + " 2스펠 " + Spell2  );
        }	
		
		return response_string;			
	}
	public String MatchCall() throws  ClassNotFoundException{		
		String MatchURL = "match/v3/matchlists/by-account/";
		String ChampionNameURL = "/static-data/v3/champions/";
		HttpGet MatchGet = new HttpGet(BaseURL + MatchURL + AccountId);
		Long GameId;
		String Lane;
		Long Champion;
		Long Time;
		String Role;
		if(Send(MatchGet) == 1)
			return response_string;	
		JSONObject json = new JSONObject(response_string);
		JSONArray j = json.getJSONArray("matches");
		for (int i = 0; i <  j.length(); i++){
            GameId = json.getJSONArray("matches").getJSONObject(i).getLong("gameId");
            Lane = json.getJSONArray("matches").getJSONObject(i).getString("lane");
            Champion = json.getJSONArray("matches").getJSONObject(i).getLong("champion");
            Time = json.getJSONArray("matches").getJSONObject(i).getLong("timestamp");
            Role = json.getJSONArray("matches").getJSONObject(i).getString("role");
            Date D = new Date(Time);
            //HttpGet ChampionNameGet = new HttpGet(BaseURL + ChampionNameURL + Champion + "?locale=ko_KR&champData=all");
            //String GetChampion = Send2(Champion);
            System.out.println("Game ID " + GameId + " Lane : " + Lane + " 역할 : " + Role +  " 챔피언 " + Champion + " 게임 날짜 " + D);
        }	
		return response_string;		
	}
	public String MatchDetail() throws  ClassNotFoundException{		
		String MatchDetailURL = "match/v3/matches/";
		HttpGet MatchGet = new HttpGet(BaseURL + MatchDetailURL + AccountId);
		Long GameId;
		String Lane;
		Long Champion;
		Long Time;
		String Role;
		if(Send(MatchGet) == 1)
			return response_string;	
		JSONObject json = new JSONObject(response_string);
		JSONArray j = json.getJSONArray("matches");
		for (int i = 0; i <  j.length(); i++){
            GameId = json.getJSONArray("matches").getJSONObject(i).getLong("gameId");
            Lane = json.getJSONArray("matches").getJSONObject(i).getString("lane");
            Champion = json.getJSONArray("matches").getJSONObject(i).getLong("champion");
            Time = json.getJSONArray("matches").getJSONObject(i).getLong("timestamp");
            Role = json.getJSONArray("matches").getJSONObject(i).getString("role");
            Date D = new Date(Time);
            //HttpGet ChampionNameGet = new HttpGet(BaseURL + ChampionNameURL + Champion + "?locale=ko_KR&champData=all");
            //String GetChampion = Send2(Champion);
            System.out.println("Game ID " + GameId + " Lane : " + Lane + " 역할 : " + Role +  " 챔피언 " + Champion + " 게임 날짜 " + D);
        }	
		return response_string;		
	}
	public int Send(HttpGet Get) throws  ClassNotFoundException{
		Charset = new BasicHeader("Accept-Charset", "application/x-www-form-urlencoded; charset=UTF-8");
		RiotKey = new BasicHeader("X-Riot-Token",Riot); //	
		Get.addHeader(Charset);
		Get.addHeader(RiotKey);
		int Error = 0;
		HttpResponse response = null;		
		try {
			response = httpclient.execute(Get);
			int statusCode = response.getStatusLine().getStatusCode();
			String message = response.getStatusLine().getReasonPhrase();
			if (statusCode == 200) {
                response_string = EntityUtils.toString(response.getEntity());                
            } else {
                System.out.println("Status code returned is " + statusCode);
                //System.out.println("An error has occured. Http status: " + message);
                response_string = message;
                Error = 1;
            }
		}
		catch(ClientProtocolException cpException) {
			cpException.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Error;
	}
	public String Send2(Long Champion) throws  ClassNotFoundException{
		String ChampionNameURL = "static-data/v3/champions/";
		HttpGet ChampionNameGet = new HttpGet(BaseURL + ChampionNameURL + Champion + "?locale=ko_KR");
		System.out.println(ChampionNameGet.toString());
		
        //String GetChampion = Send2(ChampionNameGet);
		Charset = new BasicHeader("Accept-Charset", "application/x-www-form-urlencoded; charset=UTF-8");
		RiotKey = new BasicHeader("X-Riot-Token",Riot); //	
		ChampionNameGet.addHeader(Charset);
		ChampionNameGet.addHeader(RiotKey);
		HttpResponse response = null;		
		try {
			response = httpclient.execute(ChampionNameGet);
			int statusCode = response.getStatusLine().getStatusCode();
			String message = response.getStatusLine().getReasonPhrase();
			if (statusCode == 200) {
				JSONObject json = new JSONObject(EntityUtils.toString(response.getEntity()));
				System.out.println(json);
            } else {
                System.out.println("Status code returned is " + statusCode);
                //System.out.println("An error has occured. Http status: " + message);
                return message;
            }
		}
		catch(ClientProtocolException cpException) {
			cpException.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
