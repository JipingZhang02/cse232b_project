// Generated from XPath.g4 by ANTLR 4.13.1

package edu.ucsd.cse232b.autogen;

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
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, EQS=16, EQ=17, 
		ISS=18, IS=19, AT=20, DOC=21, ID=22, WS=23, STRING=24, ESCAPE=25;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "EQS", "EQ", "ISS", 
			"IS", "AT", "DOC", "ID", "WS", "STRING", "ESCAPE"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'text()'", "'*'", "'..'", "'.'", "','", "'('", "')'", "'['", "']'", 
			"'not'", "'//'", "'/'", "'doc('", "'and'", "'or'", "'='", "'eq'", "'=='", 
			"'is'", "'@'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, "EQS", "EQ", "ISS", "IS", "AT", "DOC", "ID", 
			"WS", "STRING", "ESCAPE"
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
		"\u0004\u0000\u0019\u0096\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002"+
		"\u0001\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002"+
		"\u0004\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002"+
		"\u0007\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002"+
		"\u000b\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e"+
		"\u0002\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011"+
		"\u0002\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014"+
		"\u0002\u0015\u0007\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017"+
		"\u0002\u0018\u0007\u0018\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004"+
		"\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007"+
		"\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001"+
		"\n\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000f"+
		"\u0001\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0011\u0001\u0011"+
		"\u0001\u0011\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0013\u0001\u0013"+
		"\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0015\u0001\u0015"+
		"\u0005\u0015t\b\u0015\n\u0015\f\u0015w\t\u0015\u0001\u0016\u0004\u0016"+
		"z\b\u0016\u000b\u0016\f\u0016{\u0001\u0016\u0001\u0016\u0001\u0017\u0001"+
		"\u0017\u0001\u0017\u0005\u0017\u0083\b\u0017\n\u0017\f\u0017\u0086\t\u0017"+
		"\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0005\u0017\u008c\b\u0017"+
		"\n\u0017\f\u0017\u008f\t\u0017\u0001\u0017\u0003\u0017\u0092\b\u0017\u0001"+
		"\u0018\u0001\u0018\u0001\u0018\u0000\u0000\u0019\u0001\u0001\u0003\u0002"+
		"\u0005\u0003\u0007\u0004\t\u0005\u000b\u0006\r\u0007\u000f\b\u0011\t\u0013"+
		"\n\u0015\u000b\u0017\f\u0019\r\u001b\u000e\u001d\u000f\u001f\u0010!\u0011"+
		"#\u0012%\u0013\'\u0014)\u0015+\u0016-\u0017/\u00181\u0019\u0001\u0000"+
		"\t\u0002\u0000DDdd\u0002\u0000OOoo\u0002\u0000CCcc\u0002\u0000AZaz\u0004"+
		"\u000009AZ__az\u0003\u0000\t\n\r\r  \u0002\u0000\"\"\\\\\u0002\u0000\'"+
		"\'\\\\\u0003\u0000\"\"\'\'\\\\\u009c\u0000\u0001\u0001\u0000\u0000\u0000"+
		"\u0000\u0003\u0001\u0000\u0000\u0000\u0000\u0005\u0001\u0000\u0000\u0000"+
		"\u0000\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000\u0000\u0000\u0000"+
		"\u000b\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000\u0000\u0000\u000f"+
		"\u0001\u0000\u0000\u0000\u0000\u0011\u0001\u0000\u0000\u0000\u0000\u0013"+
		"\u0001\u0000\u0000\u0000\u0000\u0015\u0001\u0000\u0000\u0000\u0000\u0017"+
		"\u0001\u0000\u0000\u0000\u0000\u0019\u0001\u0000\u0000\u0000\u0000\u001b"+
		"\u0001\u0000\u0000\u0000\u0000\u001d\u0001\u0000\u0000\u0000\u0000\u001f"+
		"\u0001\u0000\u0000\u0000\u0000!\u0001\u0000\u0000\u0000\u0000#\u0001\u0000"+
		"\u0000\u0000\u0000%\u0001\u0000\u0000\u0000\u0000\'\u0001\u0000\u0000"+
		"\u0000\u0000)\u0001\u0000\u0000\u0000\u0000+\u0001\u0000\u0000\u0000\u0000"+
		"-\u0001\u0000\u0000\u0000\u0000/\u0001\u0000\u0000\u0000\u00001\u0001"+
		"\u0000\u0000\u0000\u00013\u0001\u0000\u0000\u0000\u0003:\u0001\u0000\u0000"+
		"\u0000\u0005<\u0001\u0000\u0000\u0000\u0007?\u0001\u0000\u0000\u0000\t"+
		"A\u0001\u0000\u0000\u0000\u000bC\u0001\u0000\u0000\u0000\rE\u0001\u0000"+
		"\u0000\u0000\u000fG\u0001\u0000\u0000\u0000\u0011I\u0001\u0000\u0000\u0000"+
		"\u0013K\u0001\u0000\u0000\u0000\u0015O\u0001\u0000\u0000\u0000\u0017R"+
		"\u0001\u0000\u0000\u0000\u0019T\u0001\u0000\u0000\u0000\u001bY\u0001\u0000"+
		"\u0000\u0000\u001d]\u0001\u0000\u0000\u0000\u001f`\u0001\u0000\u0000\u0000"+
		"!b\u0001\u0000\u0000\u0000#e\u0001\u0000\u0000\u0000%h\u0001\u0000\u0000"+
		"\u0000\'k\u0001\u0000\u0000\u0000)m\u0001\u0000\u0000\u0000+q\u0001\u0000"+
		"\u0000\u0000-y\u0001\u0000\u0000\u0000/\u0091\u0001\u0000\u0000\u0000"+
		"1\u0093\u0001\u0000\u0000\u000034\u0005t\u0000\u000045\u0005e\u0000\u0000"+
		"56\u0005x\u0000\u000067\u0005t\u0000\u000078\u0005(\u0000\u000089\u0005"+
		")\u0000\u00009\u0002\u0001\u0000\u0000\u0000:;\u0005*\u0000\u0000;\u0004"+
		"\u0001\u0000\u0000\u0000<=\u0005.\u0000\u0000=>\u0005.\u0000\u0000>\u0006"+
		"\u0001\u0000\u0000\u0000?@\u0005.\u0000\u0000@\b\u0001\u0000\u0000\u0000"+
		"AB\u0005,\u0000\u0000B\n\u0001\u0000\u0000\u0000CD\u0005(\u0000\u0000"+
		"D\f\u0001\u0000\u0000\u0000EF\u0005)\u0000\u0000F\u000e\u0001\u0000\u0000"+
		"\u0000GH\u0005[\u0000\u0000H\u0010\u0001\u0000\u0000\u0000IJ\u0005]\u0000"+
		"\u0000J\u0012\u0001\u0000\u0000\u0000KL\u0005n\u0000\u0000LM\u0005o\u0000"+
		"\u0000MN\u0005t\u0000\u0000N\u0014\u0001\u0000\u0000\u0000OP\u0005/\u0000"+
		"\u0000PQ\u0005/\u0000\u0000Q\u0016\u0001\u0000\u0000\u0000RS\u0005/\u0000"+
		"\u0000S\u0018\u0001\u0000\u0000\u0000TU\u0005d\u0000\u0000UV\u0005o\u0000"+
		"\u0000VW\u0005c\u0000\u0000WX\u0005(\u0000\u0000X\u001a\u0001\u0000\u0000"+
		"\u0000YZ\u0005a\u0000\u0000Z[\u0005n\u0000\u0000[\\\u0005d\u0000\u0000"+
		"\\\u001c\u0001\u0000\u0000\u0000]^\u0005o\u0000\u0000^_\u0005r\u0000\u0000"+
		"_\u001e\u0001\u0000\u0000\u0000`a\u0005=\u0000\u0000a \u0001\u0000\u0000"+
		"\u0000bc\u0005e\u0000\u0000cd\u0005q\u0000\u0000d\"\u0001\u0000\u0000"+
		"\u0000ef\u0005=\u0000\u0000fg\u0005=\u0000\u0000g$\u0001\u0000\u0000\u0000"+
		"hi\u0005i\u0000\u0000ij\u0005s\u0000\u0000j&\u0001\u0000\u0000\u0000k"+
		"l\u0005@\u0000\u0000l(\u0001\u0000\u0000\u0000mn\u0007\u0000\u0000\u0000"+
		"no\u0007\u0001\u0000\u0000op\u0007\u0002\u0000\u0000p*\u0001\u0000\u0000"+
		"\u0000qu\u0007\u0003\u0000\u0000rt\u0007\u0004\u0000\u0000sr\u0001\u0000"+
		"\u0000\u0000tw\u0001\u0000\u0000\u0000us\u0001\u0000\u0000\u0000uv\u0001"+
		"\u0000\u0000\u0000v,\u0001\u0000\u0000\u0000wu\u0001\u0000\u0000\u0000"+
		"xz\u0007\u0005\u0000\u0000yx\u0001\u0000\u0000\u0000z{\u0001\u0000\u0000"+
		"\u0000{y\u0001\u0000\u0000\u0000{|\u0001\u0000\u0000\u0000|}\u0001\u0000"+
		"\u0000\u0000}~\u0006\u0016\u0000\u0000~.\u0001\u0000\u0000\u0000\u007f"+
		"\u0084\u0005\"\u0000\u0000\u0080\u0083\u00031\u0018\u0000\u0081\u0083"+
		"\b\u0006\u0000\u0000\u0082\u0080\u0001\u0000\u0000\u0000\u0082\u0081\u0001"+
		"\u0000\u0000\u0000\u0083\u0086\u0001\u0000\u0000\u0000\u0084\u0082\u0001"+
		"\u0000\u0000\u0000\u0084\u0085\u0001\u0000\u0000\u0000\u0085\u0087\u0001"+
		"\u0000\u0000\u0000\u0086\u0084\u0001\u0000\u0000\u0000\u0087\u0092\u0005"+
		"\"\u0000\u0000\u0088\u008d\u0005\'\u0000\u0000\u0089\u008c\u00031\u0018"+
		"\u0000\u008a\u008c\b\u0007\u0000\u0000\u008b\u0089\u0001\u0000\u0000\u0000"+
		"\u008b\u008a\u0001\u0000\u0000\u0000\u008c\u008f\u0001\u0000\u0000\u0000"+
		"\u008d\u008b\u0001\u0000\u0000\u0000\u008d\u008e\u0001\u0000\u0000\u0000"+
		"\u008e\u0090\u0001\u0000\u0000\u0000\u008f\u008d\u0001\u0000\u0000\u0000"+
		"\u0090\u0092\u0005\'\u0000\u0000\u0091\u007f\u0001\u0000\u0000\u0000\u0091"+
		"\u0088\u0001\u0000\u0000\u0000\u00920\u0001\u0000\u0000\u0000\u0093\u0094"+
		"\u0005\\\u0000\u0000\u0094\u0095\u0007\b\u0000\u0000\u00952\u0001\u0000"+
		"\u0000\u0000\b\u0000u{\u0082\u0084\u008b\u008d\u0091\u0001\u0006\u0000"+
		"\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}