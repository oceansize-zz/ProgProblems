package problems;

import java.io.File;
import java.net.URL;

import edu.mit.jwi.Dictionary;
import edu.mit.jwi.IDictionary;
import edu.mit.jwi.item.IIndexWord;
import edu.mit.jwi.item.IIndexWordID;
import edu.mit.jwi.item.IWord;
import edu.mit.jwi.item.IWordID;
import edu.mit.jwi.item.POS;

public class Divinity {
	protected IDictionary dict = null;
	public static String[] vowels = new String[] { "a", "e", "i", "o", "u" };
	public static String[] letters = new String[] { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m",
			"n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z" };

	public void Words3Length2Chars() {
		String word = null;
		IIndexWord wordIdx = null;
		IWordID wordId = null;
		IWord iword= null;
		for (int i = 0; i < vowels.length; i++) {
			for (int n = 0; n < letters.length; n++) {
				word = vowels[i] + letters[n] + vowels[i];
				if ((wordIdx = dict.getIndexWord(word, POS.NOUN)) != null
						|| (wordIdx = dict.getIndexWord(word, POS.VERB)) != null
						|| (wordIdx = dict.getIndexWord(word, POS.ADJECTIVE)) != null) {
					System.out.println(word);
					wordId = wordIdx.getWordIDs().get(0);
					iword = dict.getWord(wordId);
					System.out.println(iword.getSynset().getGloss());
				}
			}
		}
	}
	
	public void Words3Length2Chars2() {
		String word = null;
		IIndexWord wordIdx = null;
		IWordID wordId = null;
		IWord iword= null;
		for (int i = 0; i < letters.length; i++) {
			for (int n = 0; n < vowels.length; n++) {
				word = letters[i] + vowels[n] + letters[i];
				if ((wordIdx = dict.getIndexWord(word, POS.NOUN)) != null
						|| (wordIdx = dict.getIndexWord(word, POS.VERB)) != null
						|| (wordIdx = dict.getIndexWord(word, POS.ADJECTIVE)) != null) {
					System.out.println(word);
					wordId = wordIdx.getWordIDs().get(0);
					iword = dict.getWord(wordId);
					System.out.println(iword.getSynset().getGloss());
				}
			}
		}
	}

	public void InitDict() throws Exception {
		String wnhome = System.getenv("WNHOME");
		System.out.println(wnhome);
		String path = wnhome + File.separator + "dict";
		URL url = new URL("file", null, path);

		// construct the dictionary object and open it
		this.dict = new Dictionary(url);
		this.dict.open();

		// look up first sense of the word "dog "
		IIndexWord idxWord = dict.getIndexWord("dog", POS.NOUN);

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		Divinity d = new Divinity();
		d.InitDict();
		d.Words3Length2Chars2();
	}

}
