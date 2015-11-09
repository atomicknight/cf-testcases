package org.example;

import java.util.BitSet;

import org.antlr.v4.runtime.ANTLRErrorListener;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.atn.ATNConfigSet;
import org.antlr.v4.runtime.dfa.DFA;

public class Test implements ANTLRErrorListener {
	// Error: [override.param.invalid] void syntaxError(Test this, Recognizer<? extends Object, ? extends ATNSimulator> p0, Object p1, int p2, int p3, String p4, RecognitionException p5) in org.example.Test cannot override void syntaxError(ANTLRErrorListener this, Recognizer<? extends Object, ? extends Object> p0, Object p1, int p2, int p3, String p4, RecognitionException p5)
	@Override
	public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e) {}




	// Other methods (not relevant)
	@Override
	public void reportAmbiguity(Parser paramParser, DFA paramDFA, int paramInt1, int paramInt2, boolean paramBoolean, BitSet paramBitSet, ATNConfigSet paramATNConfigSet) {}
	@Override
	public void reportAttemptingFullContext(Parser paramParser, DFA paramDFA, int paramInt1, int paramInt2, BitSet paramBitSet, ATNConfigSet paramATNConfigSet) {}
	@Override
	public void reportContextSensitivity(Parser paramParser, DFA paramDFA, int paramInt1, int paramInt2, int paramInt3, ATNConfigSet paramATNConfigSet) {}
}
