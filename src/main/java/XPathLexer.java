// Generated from XPath.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class XPathLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, Separator2=15, Separator1=16, 
		NameString=17, FileNameString=18, ContentString=19, NEWLINE=20, WS=21;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "T__11", "T__12", "T__13", "Separator2", "Separator1", 
			"NameString", "FileNameString", "ContentString", "NEWLINE", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'doc(\"'", "'\")//'", "'\")/'", "'('", "')'", "'*'", "'.'", "'..'", 
			"'text()'", "'@'", "','", "'['", "']'", "'='", "'//'", "'/'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, "Separator2", "Separator1", "NameString", "FileNameString", 
			"ContentString", "NEWLINE", "WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public XPathLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "XPath.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\u0004\u0000\u0015v\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b"+
		"\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002"+
		"\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002"+
		"\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0004\u0001"+
		"\u0004\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\t\u0001\t\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\f\u0001"+
		"\f\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000f\u0001"+
		"\u000f\u0001\u0010\u0004\u0010]\b\u0010\u000b\u0010\f\u0010^\u0001\u0011"+
		"\u0004\u0011b\b\u0011\u000b\u0011\f\u0011c\u0001\u0012\u0004\u0012g\b"+
		"\u0012\u000b\u0012\f\u0012h\u0001\u0013\u0003\u0013l\b\u0013\u0001\u0013"+
		"\u0001\u0013\u0001\u0014\u0004\u0014q\b\u0014\u000b\u0014\f\u0014r\u0001"+
		"\u0014\u0001\u0014\u0000\u0000\u0015\u0001\u0001\u0003\u0002\u0005\u0003"+
		"\u0007\u0004\t\u0005\u000b\u0006\r\u0007\u000f\b\u0011\t\u0013\n\u0015"+
		"\u000b\u0017\f\u0019\r\u001b\u000e\u001d\u000f\u001f\u0010!\u0011#\u0012"+
		"%\u0013\'\u0014)\u0015\u0001\u0000\u0004\u0003\u000009AZaz\u0004\u0000"+
		"..09AZaz\u0005\u0000-.09AZ__az\u0002\u0000\t\t  z\u0000\u0001\u0001\u0000"+
		"\u0000\u0000\u0000\u0003\u0001\u0000\u0000\u0000\u0000\u0005\u0001\u0000"+
		"\u0000\u0000\u0000\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000\u0000"+
		"\u0000\u0000\u000b\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000\u0000"+
		"\u0000\u000f\u0001\u0000\u0000\u0000\u0000\u0011\u0001\u0000\u0000\u0000"+
		"\u0000\u0013\u0001\u0000\u0000\u0000\u0000\u0015\u0001\u0000\u0000\u0000"+
		"\u0000\u0017\u0001\u0000\u0000\u0000\u0000\u0019\u0001\u0000\u0000\u0000"+
		"\u0000\u001b\u0001\u0000\u0000\u0000\u0000\u001d\u0001\u0000\u0000\u0000"+
		"\u0000\u001f\u0001\u0000\u0000\u0000\u0000!\u0001\u0000\u0000\u0000\u0000"+
		"#\u0001\u0000\u0000\u0000\u0000%\u0001\u0000\u0000\u0000\u0000\'\u0001"+
		"\u0000\u0000\u0000\u0000)\u0001\u0000\u0000\u0000\u0001+\u0001\u0000\u0000"+
		"\u0000\u00031\u0001\u0000\u0000\u0000\u00056\u0001\u0000\u0000\u0000\u0007"+
		":\u0001\u0000\u0000\u0000\t<\u0001\u0000\u0000\u0000\u000b>\u0001\u0000"+
		"\u0000\u0000\r@\u0001\u0000\u0000\u0000\u000fB\u0001\u0000\u0000\u0000"+
		"\u0011E\u0001\u0000\u0000\u0000\u0013L\u0001\u0000\u0000\u0000\u0015N"+
		"\u0001\u0000\u0000\u0000\u0017P\u0001\u0000\u0000\u0000\u0019R\u0001\u0000"+
		"\u0000\u0000\u001bT\u0001\u0000\u0000\u0000\u001dV\u0001\u0000\u0000\u0000"+
		"\u001fY\u0001\u0000\u0000\u0000!\\\u0001\u0000\u0000\u0000#a\u0001\u0000"+
		"\u0000\u0000%f\u0001\u0000\u0000\u0000\'k\u0001\u0000\u0000\u0000)p\u0001"+
		"\u0000\u0000\u0000+,\u0005d\u0000\u0000,-\u0005o\u0000\u0000-.\u0005c"+
		"\u0000\u0000./\u0005(\u0000\u0000/0\u0005\"\u0000\u00000\u0002\u0001\u0000"+
		"\u0000\u000012\u0005\"\u0000\u000023\u0005)\u0000\u000034\u0005/\u0000"+
		"\u000045\u0005/\u0000\u00005\u0004\u0001\u0000\u0000\u000067\u0005\"\u0000"+
		"\u000078\u0005)\u0000\u000089\u0005/\u0000\u00009\u0006\u0001\u0000\u0000"+
		"\u0000:;\u0005(\u0000\u0000;\b\u0001\u0000\u0000\u0000<=\u0005)\u0000"+
		"\u0000=\n\u0001\u0000\u0000\u0000>?\u0005*\u0000\u0000?\f\u0001\u0000"+
		"\u0000\u0000@A\u0005.\u0000\u0000A\u000e\u0001\u0000\u0000\u0000BC\u0005"+
		".\u0000\u0000CD\u0005.\u0000\u0000D\u0010\u0001\u0000\u0000\u0000EF\u0005"+
		"t\u0000\u0000FG\u0005e\u0000\u0000GH\u0005x\u0000\u0000HI\u0005t\u0000"+
		"\u0000IJ\u0005(\u0000\u0000JK\u0005)\u0000\u0000K\u0012\u0001\u0000\u0000"+
		"\u0000LM\u0005@\u0000\u0000M\u0014\u0001\u0000\u0000\u0000NO\u0005,\u0000"+
		"\u0000O\u0016\u0001\u0000\u0000\u0000PQ\u0005[\u0000\u0000Q\u0018\u0001"+
		"\u0000\u0000\u0000RS\u0005]\u0000\u0000S\u001a\u0001\u0000\u0000\u0000"+
		"TU\u0005=\u0000\u0000U\u001c\u0001\u0000\u0000\u0000VW\u0005/\u0000\u0000"+
		"WX\u0005/\u0000\u0000X\u001e\u0001\u0000\u0000\u0000YZ\u0005/\u0000\u0000"+
		"Z \u0001\u0000\u0000\u0000[]\u0007\u0000\u0000\u0000\\[\u0001\u0000\u0000"+
		"\u0000]^\u0001\u0000\u0000\u0000^\\\u0001\u0000\u0000\u0000^_\u0001\u0000"+
		"\u0000\u0000_\"\u0001\u0000\u0000\u0000`b\u0007\u0001\u0000\u0000a`\u0001"+
		"\u0000\u0000\u0000bc\u0001\u0000\u0000\u0000ca\u0001\u0000\u0000\u0000"+
		"cd\u0001\u0000\u0000\u0000d$\u0001\u0000\u0000\u0000eg\u0007\u0002\u0000"+
		"\u0000fe\u0001\u0000\u0000\u0000gh\u0001\u0000\u0000\u0000hf\u0001\u0000"+
		"\u0000\u0000hi\u0001\u0000\u0000\u0000i&\u0001\u0000\u0000\u0000jl\u0005"+
		"\r\u0000\u0000kj\u0001\u0000\u0000\u0000kl\u0001\u0000\u0000\u0000lm\u0001"+
		"\u0000\u0000\u0000mn\u0005\n\u0000\u0000n(\u0001\u0000\u0000\u0000oq\u0007"+
		"\u0003\u0000\u0000po\u0001\u0000\u0000\u0000qr\u0001\u0000\u0000\u0000"+
		"rp\u0001\u0000\u0000\u0000rs\u0001\u0000\u0000\u0000st\u0001\u0000\u0000"+
		"\u0000tu\u0006\u0014\u0000\u0000u*\u0001\u0000\u0000\u0000\u0006\u0000"+
		"^chkr\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}