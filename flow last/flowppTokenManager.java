/* Generated By:JavaCC: Do not edit this line. flowppTokenManager.java */

/** Token Manager. */
public class flowppTokenManager implements flowppConstants
{

  /** Debug output. */
  public  java.io.PrintStream debugStream = System.out;
  /** Set debug output. */
  public  void setDebugStream(java.io.PrintStream ds) { debugStream = ds; }
private int jjStopAtPos(int pos, int kind)
{
   jjmatchedKind = kind;
   jjmatchedPos = pos;
   return pos + 1;
}
private int jjMoveStringLiteralDfa0_0()
{
   switch(curChar)
   {
      case 65:
         return jjMoveStringLiteralDfa1_0(0x100000L);
      case 66:
         return jjMoveStringLiteralDfa1_0(0x8000L);
      case 67:
         return jjMoveStringLiteralDfa1_0(0x440000L);
      case 70:
         return jjMoveStringLiteralDfa1_0(0x40L);
      case 71:
         return jjMoveStringLiteralDfa1_0(0x820L);
      case 73:
         return jjMoveStringLiteralDfa1_0(0x180L);
      case 76:
         return jjMoveStringLiteralDfa1_0(0x10000L);
      case 78:
         return jjMoveStringLiteralDfa1_0(0x204000L);
      case 81:
         return jjMoveStringLiteralDfa1_0(0x80000L);
      case 82:
         return jjMoveStringLiteralDfa1_0(0x20000L);
      case 83:
         return jjMoveStringLiteralDfa1_0(0x2600L);
      case 86:
         return jjMoveStringLiteralDfa1_0(0x1000L);
      default :
         return 1;
   }
}
private int jjMoveStringLiteralDfa1_0(long active0)
{
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      return 1;
   }
   switch(curChar)
   {
      case 97:
         return jjMoveStringLiteralDfa2_0(active0, 0x9040L);
      case 101:
         return jjMoveStringLiteralDfa2_0(active0, 0x210820L);
      case 104:
         return jjMoveStringLiteralDfa2_0(active0, 0x400400L);
      case 105:
         return jjMoveStringLiteralDfa2_0(active0, 0x20000L);
      case 109:
         return jjMoveStringLiteralDfa2_0(active0, 0x200L);
      case 110:
         return jjMoveStringLiteralDfa2_0(active0, 0x180L);
      case 111:
         return jjMoveStringLiteralDfa2_0(active0, 0x40000L);
      case 115:
         return jjMoveStringLiteralDfa2_0(active0, 0x100000L);
      case 116:
         return jjMoveStringLiteralDfa2_0(active0, 0x2000L);
      case 117:
         return jjMoveStringLiteralDfa2_0(active0, 0x84000L);
      default :
         return 2;
   }
}
private int jjMoveStringLiteralDfa2_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return 2;
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      return 2;
   }
   switch(curChar)
   {
      case 97:
         return jjMoveStringLiteralDfa3_0(active0, 0x400200L);
      case 99:
         return jjMoveStringLiteralDfa3_0(active0, 0x8000L);
      case 102:
         return jjMoveStringLiteralDfa3_0(active0, 0x10000L);
      case 103:
         return jjMoveStringLiteralDfa3_0(active0, 0x20000L);
      case 109:
         return jjMoveStringLiteralDfa3_0(active0, 0x44000L);
      case 110:
         return jjMoveStringLiteralDfa3_0(active0, 0x20L);
      case 111:
         return jjMoveStringLiteralDfa3_0(active0, 0x80400L);
      case 114:
         if ((active0 & 0x1000L) != 0L)
            return jjStopAtPos(2, 12);
         return jjMoveStringLiteralDfa3_0(active0, 0x2000L);
      case 115:
         return jjMoveStringLiteralDfa3_0(active0, 0x100180L);
      case 116:
         return jjMoveStringLiteralDfa3_0(active0, 0x840L);
      case 119:
         return jjMoveStringLiteralDfa3_0(active0, 0x200000L);
      default :
         return 3;
   }
}
private int jjMoveStringLiteralDfa3_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return 3;
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      return 3;
   }
   switch(curChar)
   {
      case 79:
         return jjMoveStringLiteralDfa4_0(active0, 0x800L);
      case 97:
         return jjMoveStringLiteralDfa4_0(active0, 0x40L);
      case 98:
         return jjMoveStringLiteralDfa4_0(active0, 0x4000L);
      case 101:
         return jjMoveStringLiteralDfa4_0(active0, 0x1a0L);
      case 104:
         return jjMoveStringLiteralDfa4_0(active0, 0x20000L);
      case 105:
         return jjMoveStringLiteralDfa4_0(active0, 0x102000L);
      case 107:
         return jjMoveStringLiteralDfa4_0(active0, 0x8000L);
      case 108:
         return jjMoveStringLiteralDfa4_0(active0, 0x200000L);
      case 109:
         return jjMoveStringLiteralDfa4_0(active0, 0x40000L);
      case 114:
         return jjMoveStringLiteralDfa4_0(active0, 0x400000L);
      case 115:
         return jjMoveStringLiteralDfa4_0(active0, 0x200L);
      case 116:
         return jjMoveStringLiteralDfa4_0(active0, 0x90000L);
      case 119:
         return jjMoveStringLiteralDfa4_0(active0, 0x400L);
      default :
         return 4;
   }
}
private int jjMoveStringLiteralDfa4_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return 4;
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      return 4;
   }
   switch(curChar)
   {
      case 73:
         return jjMoveStringLiteralDfa5_0(active0, 0x400L);
      case 80:
         return jjMoveStringLiteralDfa5_0(active0, 0x10000L);
      case 86:
         return jjMoveStringLiteralDfa5_0(active0, 0x400000L);
      case 97:
         if ((active0 & 0x40000L) != 0L)
            return jjStopAtPos(4, 18);
         break;
      case 101:
         if ((active0 & 0x80000L) != 0L)
            return jjStopAtPos(4, 19);
         return jjMoveStringLiteralDfa5_0(active0, 0x4000L);
      case 103:
         return jjMoveStringLiteralDfa5_0(active0, 0x100000L);
      case 104:
         if ((active0 & 0x200L) != 0L)
            return jjStopAtPos(4, 9);
         break;
      case 105:
         return jjMoveStringLiteralDfa5_0(active0, 0x200000L);
      case 108:
         return jjMoveStringLiteralDfa5_0(active0, 0x40L);
      case 110:
         return jjMoveStringLiteralDfa5_0(active0, 0x2000L);
      case 114:
         return jjMoveStringLiteralDfa5_0(active0, 0x180L);
      case 115:
         return jjMoveStringLiteralDfa5_0(active0, 0x8020L);
      case 116:
         return jjMoveStringLiteralDfa5_0(active0, 0x20000L);
      case 118:
         return jjMoveStringLiteralDfa5_0(active0, 0x800L);
      default :
         return 5;
   }
   return 5;
}
private int jjMoveStringLiteralDfa5_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return 5;
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      return 5;
   }
   switch(curChar)
   {
      case 80:
         return jjMoveStringLiteralDfa6_0(active0, 0x20000L);
      case 97:
         return jjMoveStringLiteralDfa6_0(active0, 0x410000L);
      case 101:
         return jjMoveStringLiteralDfa6_0(active0, 0x800L);
      case 103:
         if ((active0 & 0x2000L) != 0L)
            return jjStopAtPos(5, 13);
         break;
      case 105:
         return jjMoveStringLiteralDfa6_0(active0, 0x60L);
      case 108:
         return jjMoveStringLiteralDfa6_0(active0, 0x8000L);
      case 110:
         if ((active0 & 0x100000L) != 0L)
            return jjStopAtPos(5, 20);
         return jjMoveStringLiteralDfa6_0(active0, 0x200000L);
      case 114:
         if ((active0 & 0x4000L) != 0L)
            return jjStopAtPos(5, 14);
         break;
      case 116:
         if ((active0 & 0x80L) != 0L)
         {
            jjmatchedKind = 7;
            jjmatchedPos = 5;
         }
         return jjMoveStringLiteralDfa6_0(active0, 0x500L);
      default :
         return 6;
   }
   return 6;
}
private int jjMoveStringLiteralDfa6_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return 6;
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      return 6;
   }
   switch(curChar)
   {
      case 73:
         return jjMoveStringLiteralDfa7_0(active0, 0x100L);
      case 84:
         return jjMoveStringLiteralDfa7_0(active0, 0x400L);
      case 97:
         return jjMoveStringLiteralDfa7_0(active0, 0x28000L);
      case 101:
         if ((active0 & 0x200000L) != 0L)
            return jjStopAtPos(6, 21);
         break;
      case 108:
         return jjMoveStringLiteralDfa7_0(active0, 0x400000L);
      case 114:
         return jjMoveStringLiteralDfa7_0(active0, 0x10800L);
      case 115:
         if ((active0 & 0x20L) != 0L)
            return jjStopAtPos(6, 5);
         break;
      case 116:
         return jjMoveStringLiteralDfa7_0(active0, 0x40L);
      default :
         return 7;
   }
   return 7;
}
private int jjMoveStringLiteralDfa7_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return 7;
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      return 7;
   }
   switch(curChar)
   {
      case 72:
         return jjMoveStringLiteralDfa8_0(active0, 0x800L);
      case 101:
         return jjMoveStringLiteralDfa8_0(active0, 0x10000L);
      case 102:
         if ((active0 & 0x100L) != 0L)
            return jjStopAtPos(7, 8);
         break;
      case 111:
         return jjMoveStringLiteralDfa8_0(active0, 0x400L);
      case 114:
         return jjMoveStringLiteralDfa8_0(active0, 0x20000L);
      case 115:
         return jjMoveStringLiteralDfa8_0(active0, 0x8000L);
      case 117:
         return jjMoveStringLiteralDfa8_0(active0, 0x400000L);
      case 121:
         if ((active0 & 0x40L) != 0L)
            return jjStopAtPos(7, 6);
         break;
      default :
         return 8;
   }
   return 8;
}
private int jjMoveStringLiteralDfa8_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return 8;
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      return 8;
   }
   switch(curChar)
   {
      case 77:
         return jjMoveStringLiteralDfa9_0(active0, 0x400L);
      case 101:
         if ((active0 & 0x400000L) != 0L)
            return jjStopAtPos(8, 22);
         return jjMoveStringLiteralDfa9_0(active0, 0x20800L);
      case 104:
         if ((active0 & 0x8000L) != 0L)
            return jjStopAtPos(8, 15);
         break;
      case 110:
         if ((active0 & 0x10000L) != 0L)
            return jjStopAtPos(8, 16);
         break;
      default :
         return 9;
   }
   return 9;
}
private int jjMoveStringLiteralDfa9_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return 9;
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      return 9;
   }
   switch(curChar)
   {
      case 101:
         if ((active0 & 0x400L) != 0L)
            return jjStopAtPos(9, 10);
         break;
      case 110:
         if ((active0 & 0x20000L) != 0L)
            return jjStopAtPos(9, 17);
         break;
      case 114:
         return jjMoveStringLiteralDfa10_0(active0, 0x800L);
      default :
         return 10;
   }
   return 10;
}
private int jjMoveStringLiteralDfa10_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return 10;
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      return 10;
   }
   switch(curChar)
   {
      case 101:
         if ((active0 & 0x800L) != 0L)
            return jjStopAtPos(10, 11);
         break;
      default :
         return 11;
   }
   return 11;
}
static final int[] jjnextStates = {
};

/** Token literal values. */
public static final String[] jjstrLiteralImages = {
"", null, null, null, null, "\107\145\156\145\163\151\163", 
"\106\141\164\141\154\151\164\171", "\111\156\163\145\162\164", "\111\156\163\145\162\164\111\146", 
"\123\155\141\163\150", "\123\150\157\167\111\164\124\157\115\145", 
"\107\145\164\117\166\145\162\110\145\162\145", "\126\141\162", "\123\164\162\151\156\147", "\116\165\155\142\145\162", 
"\102\141\143\153\163\154\141\163\150", "\114\145\146\164\120\141\162\145\156", 
"\122\151\147\150\164\120\141\162\145\156", "\103\157\155\155\141", "\121\165\157\164\145", "\101\163\163\151\147\156", 
"\116\145\167\154\151\156\145", "\103\150\141\162\126\141\154\165\145", };

/** Lexer state names. */
public static final String[] lexStateNames = {
   "DEFAULT",
};
static final long[] jjtoToken = {
   0x7fffe1L, 
};
static final long[] jjtoSkip = {
   0x1eL, 
};
protected SimpleCharStream input_stream;
private final int[] jjrounds = new int[0];
private final int[] jjstateSet = new int[0];
protected char curChar;
/** Constructor. */
public flowppTokenManager(SimpleCharStream stream){
   if (SimpleCharStream.staticFlag)
      throw new Error("ERROR: Cannot use a static CharStream class with a non-static lexical analyzer.");
   input_stream = stream;
}

/** Constructor. */
public flowppTokenManager(SimpleCharStream stream, int lexState){
   this(stream);
   SwitchTo(lexState);
}

/** Reinitialise parser. */
public void ReInit(SimpleCharStream stream)
{
   jjmatchedPos = jjnewStateCnt = 0;
   curLexState = defaultLexState;
   input_stream = stream;
   ReInitRounds();
}
private void ReInitRounds()
{
   int i;
   jjround = 0x80000001;
   for (i = 0; i-- > 0;)
      jjrounds[i] = 0x80000000;
}

/** Reinitialise parser. */
public void ReInit(SimpleCharStream stream, int lexState)
{
   ReInit(stream);
   SwitchTo(lexState);
}

/** Switch to specified lex state. */
public void SwitchTo(int lexState)
{
   if (lexState >= 1 || lexState < 0)
      throw new TokenMgrError("Error: Ignoring invalid lexical state : " + lexState + ". State unchanged.", TokenMgrError.INVALID_LEXICAL_STATE);
   else
      curLexState = lexState;
}

protected Token jjFillToken()
{
   final Token t;
   final String curTokenImage;
   final int beginLine;
   final int endLine;
   final int beginColumn;
   final int endColumn;
   String im = jjstrLiteralImages[jjmatchedKind];
   curTokenImage = (im == null) ? input_stream.GetImage() : im;
   beginLine = input_stream.getBeginLine();
   beginColumn = input_stream.getBeginColumn();
   endLine = input_stream.getEndLine();
   endColumn = input_stream.getEndColumn();
   t = Token.newToken(jjmatchedKind, curTokenImage);

   t.beginLine = beginLine;
   t.endLine = endLine;
   t.beginColumn = beginColumn;
   t.endColumn = endColumn;

   return t;
}

int curLexState = 0;
int defaultLexState = 0;
int jjnewStateCnt;
int jjround;
int jjmatchedPos;
int jjmatchedKind;

/** Get the next Token. */
public Token getNextToken() 
{
  Token matchedToken;
  int curPos = 0;

  EOFLoop :
  for (;;)
  {
   try
   {
      curChar = input_stream.BeginToken();
   }
   catch(java.io.IOException e)
   {
      jjmatchedKind = 0;
      matchedToken = jjFillToken();
      return matchedToken;
   }

   try { input_stream.backup(0);
      while (curChar <= 32 && (0x100002600L & (1L << curChar)) != 0L)
         curChar = input_stream.BeginToken();
   }
   catch (java.io.IOException e1) { continue EOFLoop; }
   jjmatchedKind = 0x7fffffff;
   jjmatchedPos = 0;
   curPos = jjMoveStringLiteralDfa0_0();
   if (jjmatchedKind != 0x7fffffff)
   {
      if (jjmatchedPos + 1 < curPos)
         input_stream.backup(curPos - jjmatchedPos - 1);
      if ((jjtoToken[jjmatchedKind >> 6] & (1L << (jjmatchedKind & 077))) != 0L)
      {
         matchedToken = jjFillToken();
         return matchedToken;
      }
      else
      {
         continue EOFLoop;
      }
   }
   int error_line = input_stream.getEndLine();
   int error_column = input_stream.getEndColumn();
   String error_after = null;
   boolean EOFSeen = false;
   try { input_stream.readChar(); input_stream.backup(1); }
   catch (java.io.IOException e1) {
      EOFSeen = true;
      error_after = curPos <= 1 ? "" : input_stream.GetImage();
      if (curChar == '\n' || curChar == '\r') {
         error_line++;
         error_column = 0;
      }
      else
         error_column++;
   }
   if (!EOFSeen) {
      input_stream.backup(1);
      error_after = curPos <= 1 ? "" : input_stream.GetImage();
   }
   throw new TokenMgrError(EOFSeen, curLexState, error_line, error_column, error_after, curChar, TokenMgrError.LEXICAL_ERROR);
  }
}

private void jjCheckNAdd(int state)
{
   if (jjrounds[state] != jjround)
   {
      jjstateSet[jjnewStateCnt++] = state;
      jjrounds[state] = jjround;
   }
}
private void jjAddStates(int start, int end)
{
   do {
      jjstateSet[jjnewStateCnt++] = jjnextStates[start];
   } while (start++ != end);
}
private void jjCheckNAddTwoStates(int state1, int state2)
{
   jjCheckNAdd(state1);
   jjCheckNAdd(state2);
}

}
