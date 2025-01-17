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
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, EQS=17, 
		EQ=18, ISS=19, IS=20, ID=21, WS=22, STRING=23, ESCAPE=24;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "EQS", 
			"EQ", "ISS", "IS", "ID", "WS", "STRING", "ESCAPE"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'text()'", "'*'", "'..'", "'.'", "','", "'('", "')'", "'['", "']'", 
			"'not'", "'//'", "'/'", "'doc('", "'@'", "'and'", "'or'", "'='", "'eq'", 
			"'=='", "'is'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, "EQS", "EQ", "ISS", "IS", "ID", "WS", "STRING", 
			"ESCAPE"
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
		"\u0004\u0000\u0018\u0090\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002"+
		"\u0001\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002"+
		"\u0004\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002"+
		"\u0007\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002"+
		"\u000b\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e"+
		"\u0002\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011"+
		"\u0002\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014"+
		"\u0002\u0015\u0007\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005"+
		"\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b"+
		"\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\r\u0001\r\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0001"+
		"\u0010\u0001\u0010\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0012\u0001"+
		"\u0012\u0001\u0012\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0014\u0001"+
		"\u0014\u0005\u0014n\b\u0014\n\u0014\f\u0014q\t\u0014\u0001\u0015\u0004"+
		"\u0015t\b\u0015\u000b\u0015\f\u0015u\u0001\u0015\u0001\u0015\u0001\u0016"+
		"\u0001\u0016\u0001\u0016\u0005\u0016}\b\u0016\n\u0016\f\u0016\u0080\t"+
		"\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0005\u0016\u0086"+
		"\b\u0016\n\u0016\f\u0016\u0089\t\u0016\u0001\u0016\u0003\u0016\u008c\b"+
		"\u0016\u0001\u0017\u0001\u0017\u0001\u0017\u0000\u0000\u0018\u0001\u0001"+
		"\u0003\u0002\u0005\u0003\u0007\u0004\t\u0005\u000b\u0006\r\u0007\u000f"+
		"\b\u0011\t\u0013\n\u0015\u000b\u0017\f\u0019\r\u001b\u000e\u001d\u000f"+
		"\u001f\u0010!\u0011#\u0012%\u0013\'\u0014)\u0015+\u0016-\u0017/\u0018"+
		"\u0001\u0000\u0006\u0002\u0000AZaz\u0004\u000009AZ__az\u0003\u0000\t\n"+
		"\r\r  \u0002\u0000\"\"\\\\\u0002\u0000\'\'\\\\\u0003\u0000\"\"\'\'\\\\"+
		"\u0096\u0000\u0001\u0001\u0000\u0000\u0000\u0000\u0003\u0001\u0000\u0000"+
		"\u0000\u0000\u0005\u0001\u0000\u0000\u0000\u0000\u0007\u0001\u0000\u0000"+
		"\u0000\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b\u0001\u0000\u0000\u0000"+
		"\u0000\r\u0001\u0000\u0000\u0000\u0000\u000f\u0001\u0000\u0000\u0000\u0000"+
		"\u0011\u0001\u0000\u0000\u0000\u0000\u0013\u0001\u0000\u0000\u0000\u0000"+
		"\u0015\u0001\u0000\u0000\u0000\u0000\u0017\u0001\u0000\u0000\u0000\u0000"+
		"\u0019\u0001\u0000\u0000\u0000\u0000\u001b\u0001\u0000\u0000\u0000\u0000"+
		"\u001d\u0001\u0000\u0000\u0000\u0000\u001f\u0001\u0000\u0000\u0000\u0000"+
		"!\u0001\u0000\u0000\u0000\u0000#\u0001\u0000\u0000\u0000\u0000%\u0001"+
		"\u0000\u0000\u0000\u0000\'\u0001\u0000\u0000\u0000\u0000)\u0001\u0000"+
		"\u0000\u0000\u0000+\u0001\u0000\u0000\u0000\u0000-\u0001\u0000\u0000\u0000"+
		"\u0000/\u0001\u0000\u0000\u0000\u00011\u0001\u0000\u0000\u0000\u00038"+
		"\u0001\u0000\u0000\u0000\u0005:\u0001\u0000\u0000\u0000\u0007=\u0001\u0000"+
		"\u0000\u0000\t?\u0001\u0000\u0000\u0000\u000bA\u0001\u0000\u0000\u0000"+
		"\rC\u0001\u0000\u0000\u0000\u000fE\u0001\u0000\u0000\u0000\u0011G\u0001"+
		"\u0000\u0000\u0000\u0013I\u0001\u0000\u0000\u0000\u0015M\u0001\u0000\u0000"+
		"\u0000\u0017P\u0001\u0000\u0000\u0000\u0019R\u0001\u0000\u0000\u0000\u001b"+
		"W\u0001\u0000\u0000\u0000\u001dY\u0001\u0000\u0000\u0000\u001f]\u0001"+
		"\u0000\u0000\u0000!`\u0001\u0000\u0000\u0000#b\u0001\u0000\u0000\u0000"+
		"%e\u0001\u0000\u0000\u0000\'h\u0001\u0000\u0000\u0000)k\u0001\u0000\u0000"+
		"\u0000+s\u0001\u0000\u0000\u0000-\u008b\u0001\u0000\u0000\u0000/\u008d"+
		"\u0001\u0000\u0000\u000012\u0005t\u0000\u000023\u0005e\u0000\u000034\u0005"+
		"x\u0000\u000045\u0005t\u0000\u000056\u0005(\u0000\u000067\u0005)\u0000"+
		"\u00007\u0002\u0001\u0000\u0000\u000089\u0005*\u0000\u00009\u0004\u0001"+
		"\u0000\u0000\u0000:;\u0005.\u0000\u0000;<\u0005.\u0000\u0000<\u0006\u0001"+
		"\u0000\u0000\u0000=>\u0005.\u0000\u0000>\b\u0001\u0000\u0000\u0000?@\u0005"+
		",\u0000\u0000@\n\u0001\u0000\u0000\u0000AB\u0005(\u0000\u0000B\f\u0001"+
		"\u0000\u0000\u0000CD\u0005)\u0000\u0000D\u000e\u0001\u0000\u0000\u0000"+
		"EF\u0005[\u0000\u0000F\u0010\u0001\u0000\u0000\u0000GH\u0005]\u0000\u0000"+
		"H\u0012\u0001\u0000\u0000\u0000IJ\u0005n\u0000\u0000JK\u0005o\u0000\u0000"+
		"KL\u0005t\u0000\u0000L\u0014\u0001\u0000\u0000\u0000MN\u0005/\u0000\u0000"+
		"NO\u0005/\u0000\u0000O\u0016\u0001\u0000\u0000\u0000PQ\u0005/\u0000\u0000"+
		"Q\u0018\u0001\u0000\u0000\u0000RS\u0005d\u0000\u0000ST\u0005o\u0000\u0000"+
		"TU\u0005c\u0000\u0000UV\u0005(\u0000\u0000V\u001a\u0001\u0000\u0000\u0000"+
		"WX\u0005@\u0000\u0000X\u001c\u0001\u0000\u0000\u0000YZ\u0005a\u0000\u0000"+
		"Z[\u0005n\u0000\u0000[\\\u0005d\u0000\u0000\\\u001e\u0001\u0000\u0000"+
		"\u0000]^\u0005o\u0000\u0000^_\u0005r\u0000\u0000_ \u0001\u0000\u0000\u0000"+
		"`a\u0005=\u0000\u0000a\"\u0001\u0000\u0000\u0000bc\u0005e\u0000\u0000"+
		"cd\u0005q\u0000\u0000d$\u0001\u0000\u0000\u0000ef\u0005=\u0000\u0000f"+
		"g\u0005=\u0000\u0000g&\u0001\u0000\u0000\u0000hi\u0005i\u0000\u0000ij"+
		"\u0005s\u0000\u0000j(\u0001\u0000\u0000\u0000ko\u0007\u0000\u0000\u0000"+
		"ln\u0007\u0001\u0000\u0000ml\u0001\u0000\u0000\u0000nq\u0001\u0000\u0000"+
		"\u0000om\u0001\u0000\u0000\u0000op\u0001\u0000\u0000\u0000p*\u0001\u0000"+
		"\u0000\u0000qo\u0001\u0000\u0000\u0000rt\u0007\u0002\u0000\u0000sr\u0001"+
		"\u0000\u0000\u0000tu\u0001\u0000\u0000\u0000us\u0001\u0000\u0000\u0000"+
		"uv\u0001\u0000\u0000\u0000vw\u0001\u0000\u0000\u0000wx\u0006\u0015\u0000"+
		"\u0000x,\u0001\u0000\u0000\u0000y~\u0005\"\u0000\u0000z}\u0003/\u0017"+
		"\u0000{}\b\u0003\u0000\u0000|z\u0001\u0000\u0000\u0000|{\u0001\u0000\u0000"+
		"\u0000}\u0080\u0001\u0000\u0000\u0000~|\u0001\u0000\u0000\u0000~\u007f"+
		"\u0001\u0000\u0000\u0000\u007f\u0081\u0001\u0000\u0000\u0000\u0080~\u0001"+
		"\u0000\u0000\u0000\u0081\u008c\u0005\"\u0000\u0000\u0082\u0087\u0005\'"+
		"\u0000\u0000\u0083\u0086\u0003/\u0017\u0000\u0084\u0086\b\u0004\u0000"+
		"\u0000\u0085\u0083\u0001\u0000\u0000\u0000\u0085\u0084\u0001\u0000\u0000"+
		"\u0000\u0086\u0089\u0001\u0000\u0000\u0000\u0087\u0085\u0001\u0000\u0000"+
		"\u0000\u0087\u0088\u0001\u0000\u0000\u0000\u0088\u008a\u0001\u0000\u0000"+
		"\u0000\u0089\u0087\u0001\u0000\u0000\u0000\u008a\u008c\u0005\'\u0000\u0000"+
		"\u008by\u0001\u0000\u0000\u0000\u008b\u0082\u0001\u0000\u0000\u0000\u008c"+
		".\u0001\u0000\u0000\u0000\u008d\u008e\u0005\\\u0000\u0000\u008e\u008f"+
		"\u0007\u0005\u0000\u0000\u008f0\u0001\u0000\u0000\u0000\b\u0000ou|~\u0085"+
		"\u0087\u008b\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}