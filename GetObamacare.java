import okhttp3.*;

public class String GetObamacare {
    OkHttpClient client = new OkHttpClient();

    Request request = new Request.Builder()
            .url("https://www.healthcare.gov/glossary/patient-protection-and-affordable-care-act.json")
            .get().build();
    Response response = client.newCall(request).execute();

    return response.content.toString();

}
