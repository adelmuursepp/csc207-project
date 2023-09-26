OkHttpClient client = new OkHttpClient();

Request request = new Request.Builder()
	.url("https://healthgraphic-healthgraphic-v1.p.rapidapi.com//api.healthgraphic.com/v1/conditions/%7Bname%7D")
	.get()
	.addHeader("X-RapidAPI-Key", "SIGN-UP-FOR-KEY")
	.addHeader("X-RapidAPI-Host", "healthgraphic-healthgraphic-v1.p.rapidapi.com")
	.build();

Response response = client.newCall(request).execute();
