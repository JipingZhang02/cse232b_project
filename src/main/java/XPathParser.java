// Generated from XPath.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class XPathParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, Separator2=15, Separator1=16, 
		NameString=17, FileNameString=18, ContentString=19, NEWLINE=20, WS=21;
	public static final int
		RULE_abspath = 0, RULE_relpath = 1, RULE_filter = 2;
	private static String[] makeRuleNames() {
		return new String[] {
			"abspath", "relpath", "filter"
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

	@Override
	public String getGrammarFileName() { return "XPath.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public XPathParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AbspathContext extends ParserRuleContext {
		public AbspathContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_abspath; }
	 
		public AbspathContext() { }
		public void copyFrom(AbspathContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AbsPath2Context extends AbspathContext {
		public TerminalNode FileNameString() { return getToken(XPathParser.FileNameString, 0); }
		public RelpathContext relpath() {
			return getRuleContext(RelpathContext.class,0);
		}
		public AbsPath2Context(AbspathContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).enterAbsPath2(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).exitAbsPath2(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPathVisitor ) return ((XPathVisitor<? extends T>)visitor).visitAbsPath2(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AbsPath1Context extends AbspathContext {
		public TerminalNode FileNameString() { return getToken(XPathParser.FileNameString, 0); }
		public RelpathContext relpath() {
			return getRuleContext(RelpathContext.class,0);
		}
		public AbsPath1Context(AbspathContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).enterAbsPath1(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).exitAbsPath1(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPathVisitor ) return ((XPathVisitor<? extends T>)visitor).visitAbsPath1(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AbspathContext abspath() throws RecognitionException {
		AbspathContext _localctx = new AbspathContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_abspath);
		try {
			setState(14);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				_localctx = new AbsPath2Context(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(6);
				match(T__0);
				setState(7);
				match(FileNameString);
				setState(8);
				match(T__1);
				setState(9);
				relpath(0);
				}
				break;
			case 2:
				_localctx = new AbsPath1Context(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(10);
				match(T__0);
				setState(11);
				match(FileNameString);
				setState(12);
				match(T__2);
				setState(13);
				relpath(0);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class RelpathContext extends ParserRuleContext {
		public RelpathContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relpath; }
	 
		public RelpathContext() { }
		public void copyFrom(RelpathContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AllChildrenContext extends RelpathContext {
		public AllChildrenContext(RelpathContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).enterAllChildren(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).exitAllChildren(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPathVisitor ) return ((XPathVisitor<? extends T>)visitor).visitAllChildren(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AttrNameContext extends RelpathContext {
		public TerminalNode NameString() { return getToken(XPathParser.NameString, 0); }
		public AttrNameContext(RelpathContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).enterAttrName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).exitAttrName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPathVisitor ) return ((XPathVisitor<? extends T>)visitor).visitAttrName(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class RelPath2Context extends RelpathContext {
		public List<RelpathContext> relpath() {
			return getRuleContexts(RelpathContext.class);
		}
		public RelpathContext relpath(int i) {
			return getRuleContext(RelpathContext.class,i);
		}
		public TerminalNode Separator2() { return getToken(XPathParser.Separator2, 0); }
		public RelPath2Context(RelpathContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).enterRelPath2(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).exitRelPath2(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPathVisitor ) return ((XPathVisitor<? extends T>)visitor).visitRelPath2(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BracketRelPathContext extends RelpathContext {
		public RelpathContext relpath() {
			return getRuleContext(RelpathContext.class,0);
		}
		public BracketRelPathContext(RelpathContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).enterBracketRelPath(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).exitBracketRelPath(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPathVisitor ) return ((XPathVisitor<? extends T>)visitor).visitBracketRelPath(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TagNameContext extends RelpathContext {
		public TerminalNode NameString() { return getToken(XPathParser.NameString, 0); }
		public TagNameContext(RelpathContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).enterTagName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).exitTagName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPathVisitor ) return ((XPathVisitor<? extends T>)visitor).visitTagName(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ParentContext extends RelpathContext {
		public ParentContext(RelpathContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).enterParent(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).exitParent(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPathVisitor ) return ((XPathVisitor<? extends T>)visitor).visitParent(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class RelPath1Context extends RelpathContext {
		public List<RelpathContext> relpath() {
			return getRuleContexts(RelpathContext.class);
		}
		public RelpathContext relpath(int i) {
			return getRuleContext(RelpathContext.class,i);
		}
		public TerminalNode Separator1() { return getToken(XPathParser.Separator1, 0); }
		public RelPath1Context(RelpathContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).enterRelPath1(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).exitRelPath1(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPathVisitor ) return ((XPathVisitor<? extends T>)visitor).visitRelPath1(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FilteredRelpathContext extends RelpathContext {
		public RelpathContext relpath() {
			return getRuleContext(RelpathContext.class,0);
		}
		public FilterContext filter() {
			return getRuleContext(FilterContext.class,0);
		}
		public FilteredRelpathContext(RelpathContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).enterFilteredRelpath(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).exitFilteredRelpath(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPathVisitor ) return ((XPathVisitor<? extends T>)visitor).visitFilteredRelpath(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class RelPathTupleContext extends RelpathContext {
		public List<RelpathContext> relpath() {
			return getRuleContexts(RelpathContext.class);
		}
		public RelpathContext relpath(int i) {
			return getRuleContext(RelpathContext.class,i);
		}
		public RelPathTupleContext(RelpathContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).enterRelPathTuple(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).exitRelPathTuple(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPathVisitor ) return ((XPathVisitor<? extends T>)visitor).visitRelPathTuple(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CurrTagContext extends RelpathContext {
		public CurrTagContext(RelpathContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).enterCurrTag(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).exitCurrTag(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPathVisitor ) return ((XPathVisitor<? extends T>)visitor).visitCurrTag(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class GetTextContext extends RelpathContext {
		public GetTextContext(RelpathContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).enterGetText(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).exitGetText(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPathVisitor ) return ((XPathVisitor<? extends T>)visitor).visitGetText(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RelpathContext relpath() throws RecognitionException {
		return relpath(0);
	}

	private RelpathContext relpath(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		RelpathContext _localctx = new RelpathContext(_ctx, _parentState);
		RelpathContext _prevctx = _localctx;
		int _startState = 2;
		enterRecursionRule(_localctx, 2, RULE_relpath, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(28);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__3:
				{
				_localctx = new BracketRelPathContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(17);
				match(T__3);
				setState(18);
				relpath(0);
				setState(19);
				match(T__4);
				}
				break;
			case NameString:
				{
				_localctx = new TagNameContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(21);
				match(NameString);
				}
				break;
			case T__5:
				{
				_localctx = new AllChildrenContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(22);
				match(T__5);
				}
				break;
			case T__6:
				{
				_localctx = new CurrTagContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(23);
				match(T__6);
				}
				break;
			case T__7:
				{
				_localctx = new ParentContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(24);
				match(T__7);
				}
				break;
			case T__8:
				{
				_localctx = new GetTextContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(25);
				match(T__8);
				}
				break;
			case T__9:
				{
				_localctx = new AttrNameContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(26);
				match(T__9);
				setState(27);
				match(NameString);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(46);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(44);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
					case 1:
						{
						_localctx = new RelPath2Context(new RelpathContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_relpath);
						setState(30);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(31);
						match(Separator2);
						setState(32);
						relpath(5);
						}
						break;
					case 2:
						{
						_localctx = new RelPath1Context(new RelpathContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_relpath);
						setState(33);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(34);
						match(Separator1);
						setState(35);
						relpath(4);
						}
						break;
					case 3:
						{
						_localctx = new RelPathTupleContext(new RelpathContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_relpath);
						setState(36);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(37);
						match(T__10);
						setState(38);
						relpath(3);
						}
						break;
					case 4:
						{
						_localctx = new FilteredRelpathContext(new RelpathContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_relpath);
						setState(39);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(40);
						match(T__11);
						setState(41);
						filter();
						setState(42);
						match(T__12);
						}
						break;
					}
					} 
				}
				setState(48);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FilterContext extends ParserRuleContext {
		public RelpathContext relpath() {
			return getRuleContext(RelpathContext.class,0);
		}
		public TerminalNode NameString() { return getToken(XPathParser.NameString, 0); }
		public FilterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_filter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).enterFilter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).exitFilter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPathVisitor ) return ((XPathVisitor<? extends T>)visitor).visitFilter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FilterContext filter() throws RecognitionException {
		FilterContext _localctx = new FilterContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_filter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(49);
			relpath(0);
			setState(50);
			match(T__13);
			setState(51);
			match(NameString);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 1:
			return relpath_sempred((RelpathContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean relpath_sempred(RelpathContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 4);
		case 1:
			return precpred(_ctx, 3);
		case 2:
			return precpred(_ctx, 2);
		case 3:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001\u00156\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0003\u0000\u000f\b\u0000\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0003"+
		"\u0001\u001d\b\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0005\u0001-\b\u0001\n\u0001"+
		"\f\u00010\t\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0000\u0001\u0002\u0003\u0000\u0002\u0004\u0000\u0000=\u0000\u000e"+
		"\u0001\u0000\u0000\u0000\u0002\u001c\u0001\u0000\u0000\u0000\u00041\u0001"+
		"\u0000\u0000\u0000\u0006\u0007\u0005\u0001\u0000\u0000\u0007\b\u0005\u0012"+
		"\u0000\u0000\b\t\u0005\u0002\u0000\u0000\t\u000f\u0003\u0002\u0001\u0000"+
		"\n\u000b\u0005\u0001\u0000\u0000\u000b\f\u0005\u0012\u0000\u0000\f\r\u0005"+
		"\u0003\u0000\u0000\r\u000f\u0003\u0002\u0001\u0000\u000e\u0006\u0001\u0000"+
		"\u0000\u0000\u000e\n\u0001\u0000\u0000\u0000\u000f\u0001\u0001\u0000\u0000"+
		"\u0000\u0010\u0011\u0006\u0001\uffff\uffff\u0000\u0011\u0012\u0005\u0004"+
		"\u0000\u0000\u0012\u0013\u0003\u0002\u0001\u0000\u0013\u0014\u0005\u0005"+
		"\u0000\u0000\u0014\u001d\u0001\u0000\u0000\u0000\u0015\u001d\u0005\u0011"+
		"\u0000\u0000\u0016\u001d\u0005\u0006\u0000\u0000\u0017\u001d\u0005\u0007"+
		"\u0000\u0000\u0018\u001d\u0005\b\u0000\u0000\u0019\u001d\u0005\t\u0000"+
		"\u0000\u001a\u001b\u0005\n\u0000\u0000\u001b\u001d\u0005\u0011\u0000\u0000"+
		"\u001c\u0010\u0001\u0000\u0000\u0000\u001c\u0015\u0001\u0000\u0000\u0000"+
		"\u001c\u0016\u0001\u0000\u0000\u0000\u001c\u0017\u0001\u0000\u0000\u0000"+
		"\u001c\u0018\u0001\u0000\u0000\u0000\u001c\u0019\u0001\u0000\u0000\u0000"+
		"\u001c\u001a\u0001\u0000\u0000\u0000\u001d.\u0001\u0000\u0000\u0000\u001e"+
		"\u001f\n\u0004\u0000\u0000\u001f \u0005\u000f\u0000\u0000 -\u0003\u0002"+
		"\u0001\u0005!\"\n\u0003\u0000\u0000\"#\u0005\u0010\u0000\u0000#-\u0003"+
		"\u0002\u0001\u0004$%\n\u0002\u0000\u0000%&\u0005\u000b\u0000\u0000&-\u0003"+
		"\u0002\u0001\u0003\'(\n\u0001\u0000\u0000()\u0005\f\u0000\u0000)*\u0003"+
		"\u0004\u0002\u0000*+\u0005\r\u0000\u0000+-\u0001\u0000\u0000\u0000,\u001e"+
		"\u0001\u0000\u0000\u0000,!\u0001\u0000\u0000\u0000,$\u0001\u0000\u0000"+
		"\u0000,\'\u0001\u0000\u0000\u0000-0\u0001\u0000\u0000\u0000.,\u0001\u0000"+
		"\u0000\u0000./\u0001\u0000\u0000\u0000/\u0003\u0001\u0000\u0000\u0000"+
		"0.\u0001\u0000\u0000\u000012\u0003\u0002\u0001\u000023\u0005\u000e\u0000"+
		"\u000034\u0005\u0011\u0000\u00004\u0005\u0001\u0000\u0000\u0000\u0004"+
		"\u000e\u001c,.";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}