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
		T__0=1, T__1=2, SL=3, DSL=4, SELF=5, PENT=6, STAR=7, LPR=8, RPR=9, LSB=10, 
		RSB=11, COMMA=12, EQS=13, EQ=14, ISS=15, IS=16, NEG=17, CONJ=18, TEXT=19, 
		AT=20, DOC=21, ID=22, WS=23, STRING=24, ESCAPE=25;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "SL", "DSL", "SELF", "PENT", "STAR", "LPR", "RPR", "LSB", 
			"RSB", "COMMA", "EQS", "EQ", "ISS", "IS", "NEG", "CONJ", "TEXT", "AT", 
			"DOC", "ID", "WS", "STRING", "ESCAPE"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'and'", "'or'", "'/'", "'//'", "'.'", "'..'", "'*'", "'('", "')'", 
			"'['", "']'", "','", "'='", "'eq'", "'=='", "'is'", "'not'", null, "'text()'", 
			"'@'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, "SL", "DSL", "SELF", "PENT", "STAR", "LPR", "RPR", 
			"LSB", "RSB", "COMMA", "EQS", "EQ", "ISS", "IS", "NEG", "CONJ", "TEXT", 
			"AT", "DOC", "ID", "WS", "STRING", "ESCAPE"
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
		"\u0004\u0000\u0019\u0098\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002"+
		"\u0001\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002"+
		"\u0004\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002"+
		"\u0007\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002"+
		"\u000b\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e"+
		"\u0002\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011"+
		"\u0002\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014"+
		"\u0002\u0015\u0007\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017"+
		"\u0002\u0018\u0007\u0018\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\b\u0001"+
		"\b\u0001\t\u0001\t\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\f\u0001"+
		"\f\u0001\r\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010"+
		"\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0003\u0011"+
		"e\b\u0011\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012"+
		"\u0001\u0012\u0001\u0012\u0001\u0013\u0001\u0013\u0001\u0014\u0001\u0014"+
		"\u0001\u0014\u0001\u0014\u0001\u0015\u0001\u0015\u0005\u0015v\b\u0015"+
		"\n\u0015\f\u0015y\t\u0015\u0001\u0016\u0004\u0016|\b\u0016\u000b\u0016"+
		"\f\u0016}\u0001\u0016\u0001\u0016\u0001\u0017\u0001\u0017\u0001\u0017"+
		"\u0005\u0017\u0085\b\u0017\n\u0017\f\u0017\u0088\t\u0017\u0001\u0017\u0001"+
		"\u0017\u0001\u0017\u0001\u0017\u0005\u0017\u008e\b\u0017\n\u0017\f\u0017"+
		"\u0091\t\u0017\u0001\u0017\u0003\u0017\u0094\b\u0017\u0001\u0018\u0001"+
		"\u0018\u0001\u0018\u0000\u0000\u0019\u0001\u0001\u0003\u0002\u0005\u0003"+
		"\u0007\u0004\t\u0005\u000b\u0006\r\u0007\u000f\b\u0011\t\u0013\n\u0015"+
		"\u000b\u0017\f\u0019\r\u001b\u000e\u001d\u000f\u001f\u0010!\u0011#\u0012"+
		"%\u0013\'\u0014)\u0015+\u0016-\u0017/\u00181\u0019\u0001\u0000\t\u0002"+
		"\u0000DDdd\u0002\u0000OOoo\u0002\u0000CCcc\u0002\u0000AZaz\u0004\u0000"+
		"09AZ__az\u0003\u0000\t\n\r\r  \u0002\u0000\"\"\\\\\u0002\u0000\'\'\\\\"+
		"\u0003\u0000\"\"\'\'\\\\\u009f\u0000\u0001\u0001\u0000\u0000\u0000\u0000"+
		"\u0003\u0001\u0000\u0000\u0000\u0000\u0005\u0001\u0000\u0000\u0000\u0000"+
		"\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b"+
		"\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000\u0000\u0000\u000f\u0001"+
		"\u0000\u0000\u0000\u0000\u0011\u0001\u0000\u0000\u0000\u0000\u0013\u0001"+
		"\u0000\u0000\u0000\u0000\u0015\u0001\u0000\u0000\u0000\u0000\u0017\u0001"+
		"\u0000\u0000\u0000\u0000\u0019\u0001\u0000\u0000\u0000\u0000\u001b\u0001"+
		"\u0000\u0000\u0000\u0000\u001d\u0001\u0000\u0000\u0000\u0000\u001f\u0001"+
		"\u0000\u0000\u0000\u0000!\u0001\u0000\u0000\u0000\u0000#\u0001\u0000\u0000"+
		"\u0000\u0000%\u0001\u0000\u0000\u0000\u0000\'\u0001\u0000\u0000\u0000"+
		"\u0000)\u0001\u0000\u0000\u0000\u0000+\u0001\u0000\u0000\u0000\u0000-"+
		"\u0001\u0000\u0000\u0000\u0000/\u0001\u0000\u0000\u0000\u00001\u0001\u0000"+
		"\u0000\u0000\u00013\u0001\u0000\u0000\u0000\u00037\u0001\u0000\u0000\u0000"+
		"\u0005:\u0001\u0000\u0000\u0000\u0007<\u0001\u0000\u0000\u0000\t?\u0001"+
		"\u0000\u0000\u0000\u000bA\u0001\u0000\u0000\u0000\rD\u0001\u0000\u0000"+
		"\u0000\u000fF\u0001\u0000\u0000\u0000\u0011H\u0001\u0000\u0000\u0000\u0013"+
		"J\u0001\u0000\u0000\u0000\u0015L\u0001\u0000\u0000\u0000\u0017N\u0001"+
		"\u0000\u0000\u0000\u0019P\u0001\u0000\u0000\u0000\u001bR\u0001\u0000\u0000"+
		"\u0000\u001dU\u0001\u0000\u0000\u0000\u001fX\u0001\u0000\u0000\u0000!"+
		"[\u0001\u0000\u0000\u0000#d\u0001\u0000\u0000\u0000%f\u0001\u0000\u0000"+
		"\u0000\'m\u0001\u0000\u0000\u0000)o\u0001\u0000\u0000\u0000+s\u0001\u0000"+
		"\u0000\u0000-{\u0001\u0000\u0000\u0000/\u0093\u0001\u0000\u0000\u0000"+
		"1\u0095\u0001\u0000\u0000\u000034\u0005a\u0000\u000045\u0005n\u0000\u0000"+
		"56\u0005d\u0000\u00006\u0002\u0001\u0000\u0000\u000078\u0005o\u0000\u0000"+
		"89\u0005r\u0000\u00009\u0004\u0001\u0000\u0000\u0000:;\u0005/\u0000\u0000"+
		";\u0006\u0001\u0000\u0000\u0000<=\u0005/\u0000\u0000=>\u0005/\u0000\u0000"+
		">\b\u0001\u0000\u0000\u0000?@\u0005.\u0000\u0000@\n\u0001\u0000\u0000"+
		"\u0000AB\u0005.\u0000\u0000BC\u0005.\u0000\u0000C\f\u0001\u0000\u0000"+
		"\u0000DE\u0005*\u0000\u0000E\u000e\u0001\u0000\u0000\u0000FG\u0005(\u0000"+
		"\u0000G\u0010\u0001\u0000\u0000\u0000HI\u0005)\u0000\u0000I\u0012\u0001"+
		"\u0000\u0000\u0000JK\u0005[\u0000\u0000K\u0014\u0001\u0000\u0000\u0000"+
		"LM\u0005]\u0000\u0000M\u0016\u0001\u0000\u0000\u0000NO\u0005,\u0000\u0000"+
		"O\u0018\u0001\u0000\u0000\u0000PQ\u0005=\u0000\u0000Q\u001a\u0001\u0000"+
		"\u0000\u0000RS\u0005e\u0000\u0000ST\u0005q\u0000\u0000T\u001c\u0001\u0000"+
		"\u0000\u0000UV\u0005=\u0000\u0000VW\u0005=\u0000\u0000W\u001e\u0001\u0000"+
		"\u0000\u0000XY\u0005i\u0000\u0000YZ\u0005s\u0000\u0000Z \u0001\u0000\u0000"+
		"\u0000[\\\u0005n\u0000\u0000\\]\u0005o\u0000\u0000]^\u0005t\u0000\u0000"+
		"^\"\u0001\u0000\u0000\u0000_`\u0005a\u0000\u0000`a\u0005n\u0000\u0000"+
		"ae\u0005d\u0000\u0000bc\u0005o\u0000\u0000ce\u0005r\u0000\u0000d_\u0001"+
		"\u0000\u0000\u0000db\u0001\u0000\u0000\u0000e$\u0001\u0000\u0000\u0000"+
		"fg\u0005t\u0000\u0000gh\u0005e\u0000\u0000hi\u0005x\u0000\u0000ij\u0005"+
		"t\u0000\u0000jk\u0005(\u0000\u0000kl\u0005)\u0000\u0000l&\u0001\u0000"+
		"\u0000\u0000mn\u0005@\u0000\u0000n(\u0001\u0000\u0000\u0000op\u0007\u0000"+
		"\u0000\u0000pq\u0007\u0001\u0000\u0000qr\u0007\u0002\u0000\u0000r*\u0001"+
		"\u0000\u0000\u0000sw\u0007\u0003\u0000\u0000tv\u0007\u0004\u0000\u0000"+
		"ut\u0001\u0000\u0000\u0000vy\u0001\u0000\u0000\u0000wu\u0001\u0000\u0000"+
		"\u0000wx\u0001\u0000\u0000\u0000x,\u0001\u0000\u0000\u0000yw\u0001\u0000"+
		"\u0000\u0000z|\u0007\u0005\u0000\u0000{z\u0001\u0000\u0000\u0000|}\u0001"+
		"\u0000\u0000\u0000}{\u0001\u0000\u0000\u0000}~\u0001\u0000\u0000\u0000"+
		"~\u007f\u0001\u0000\u0000\u0000\u007f\u0080\u0006\u0016\u0000\u0000\u0080"+
		".\u0001\u0000\u0000\u0000\u0081\u0086\u0005\"\u0000\u0000\u0082\u0085"+
		"\u00031\u0018\u0000\u0083\u0085\b\u0006\u0000\u0000\u0084\u0082\u0001"+
		"\u0000\u0000\u0000\u0084\u0083\u0001\u0000\u0000\u0000\u0085\u0088\u0001"+
		"\u0000\u0000\u0000\u0086\u0084\u0001\u0000\u0000\u0000\u0086\u0087\u0001"+
		"\u0000\u0000\u0000\u0087\u0089\u0001\u0000\u0000\u0000\u0088\u0086\u0001"+
		"\u0000\u0000\u0000\u0089\u0094\u0005\"\u0000\u0000\u008a\u008f\u0005\'"+
		"\u0000\u0000\u008b\u008e\u00031\u0018\u0000\u008c\u008e\b\u0007\u0000"+
		"\u0000\u008d\u008b\u0001\u0000\u0000\u0000\u008d\u008c\u0001\u0000\u0000"+
		"\u0000\u008e\u0091\u0001\u0000\u0000\u0000\u008f\u008d\u0001\u0000\u0000"+
		"\u0000\u008f\u0090\u0001\u0000\u0000\u0000\u0090\u0092\u0001\u0000\u0000"+
		"\u0000\u0091\u008f\u0001\u0000\u0000\u0000\u0092\u0094\u0005\'\u0000\u0000"+
		"\u0093\u0081\u0001\u0000\u0000\u0000\u0093\u008a\u0001\u0000\u0000\u0000"+
		"\u00940\u0001\u0000\u0000\u0000\u0095\u0096\u0005\\\u0000\u0000\u0096"+
		"\u0097\u0007\b\u0000\u0000\u00972\u0001\u0000\u0000\u0000\t\u0000dw}\u0084"+
		"\u0086\u008d\u008f\u0093\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}