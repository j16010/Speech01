package speech01;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import com.ibm.watson.developer_cloud.text_to_speech.v1.TextToSpeech;
import com.ibm.watson.developer_cloud.text_to_speech.v1.model.SynthesizeOptions;
import com.ibm.watson.developer_cloud.text_to_speech.v1.util.WaveUtils;

public class Speech01_main {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		TextToSpeech synthesizer = new TextToSpeech();
		synthesizer.setUsernameAndPassword("j16010"," j16010");

		
		String translaion = "今日はいい天気ですね";
		
		SynthesizeOptions synthesizeOptions = new SynthesizeOptions.Builder()
			       .text(translaion)
			       .voice(SynthesizeOptions.Voice.JA_JP_EMIVOICE)
			       .accept(SynthesizeOptions.Accept.AUDIO_WAV)
			       .build();
			   InputStream in = synthesizer.synthesize(synthesizeOptions).execute();
			 
			   try {
				writeToFile(WaveUtils.reWriteWaveHeader(in), new File("output.wav"));
			} catch (IOException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}

	}
	
	private static void writeToFile(InputStream in, File file) {
		   try {
		     OutputStream out = new FileOutputStream(file);
		     byte[] buf = new byte[1024];
		     int len;
		     while ((len = in.read(buf)) > 0) {
		       out.write(buf, 0, len);
		     }
		     out.close();
		     in.close();
		   } catch (Exception e) {
		     e.printStackTrace();
		   }
		 }

}


