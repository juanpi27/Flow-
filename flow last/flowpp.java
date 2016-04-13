/* Generated By:JavaCC: Do not edit this line. flowpp.java */
        public class flowpp implements flowppConstants {
                        public static void main( String[] args){
                                try{
                                        flowpp parser = new flowpp(System.in);
                                        parser.start();
                                        System.out.println("Syntax is correct");
                                } catch (Throwable e){
                                        System.out.println(e.getMessage());
                                }
                        }

  final public void start() throws ParseException {
    jj_consume_token(Genesis);
    jj_consume_token(LeftParen);
    jj_consume_token(Var);
    jj_consume_token(RightParen);
    jj_consume_token(Newline);
    label_1:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case Fatality:
      case Insert:
      case InsertIf:
      case Smash:
      case ShowItToMe:
      case GetOverHere:
      case Var:
        ;
        break;
      default:
        jj_la1[0] = jj_gen;
        break label_1;
      }
      statements();
    }
    jj_consume_token(0);
  }

  final public void statements() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case Var:
      assign();
      jj_consume_token(Newline);
      break;
    case Fatality:
    case Insert:
    case InsertIf:
    case Smash:
    case ShowItToMe:
    case GetOverHere:
      command();
      jj_consume_token(Newline);
      break;
    default:
      jj_la1[1] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  final public void assign() throws ParseException {
    jj_consume_token(Var);
    jj_consume_token(Assign);
    jj_consume_token(Quote);
    jj_consume_token(String);
    jj_consume_token(Quote);
  }

  final public void command() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case Insert:
      jj_consume_token(Insert);
      jj_consume_token(LeftParen);
      jj_consume_token(Var);
      jj_consume_token(Comma);
      jj_consume_token(Var);
      jj_consume_token(Comma);
      jj_consume_token(Var);
      jj_consume_token(RightParen);
      break;
    case InsertIf:
      jj_consume_token(InsertIf);
      jj_consume_token(LeftParen);
      jj_consume_token(Var);
      jj_consume_token(Comma);
      jj_consume_token(Var);
      jj_consume_token(Comma);
      jj_consume_token(Var);
      jj_consume_token(Comma);
      jj_consume_token(Var);
      jj_consume_token(RightParen);
      break;
    case Smash:
      jj_consume_token(Smash);
      jj_consume_token(LeftParen);
      jj_consume_token(Var);
      jj_consume_token(RightParen);
      break;
    case ShowItToMe:
      jj_consume_token(ShowItToMe);
      jj_consume_token(LeftParen);
      jj_consume_token(Var);
      jj_consume_token(RightParen);
      break;
    case GetOverHere:
      jj_consume_token(GetOverHere);
      jj_consume_token(LeftParen);
      jj_consume_token(Var);
      jj_consume_token(Comma);
      jj_consume_token(Var);
      jj_consume_token(RightParen);
      break;
    case Fatality:
      jj_consume_token(Fatality);
      jj_consume_token(LeftParen);
      jj_consume_token(Var);
      jj_consume_token(RightParen);
      break;
    default:
      jj_la1[2] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  /** Generated Token Manager. */
  public flowppTokenManager token_source;
  SimpleCharStream jj_input_stream;
  /** Current token. */
  public Token token;
  /** Next token. */
  public Token jj_nt;
  private int jj_ntk;
  private int jj_gen;
  final private int[] jj_la1 = new int[3];
  static private int[] jj_la1_0;
  static {
      jj_la1_init_0();
   }
   private static void jj_la1_init_0() {
      jj_la1_0 = new int[] {0x1fc0,0x1fc0,0xfc0,};
   }

  /** Constructor with InputStream. */
  public flowpp(java.io.InputStream stream) {
     this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public flowpp(java.io.InputStream stream, String encoding) {
    try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source = new flowppTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 3; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(java.io.InputStream stream) {
     ReInit(stream, null);
  }
  /** Reinitialise. */
  public void ReInit(java.io.InputStream stream, String encoding) {
    try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 3; i++) jj_la1[i] = -1;
  }

  /** Constructor. */
  public flowpp(java.io.Reader stream) {
    jj_input_stream = new SimpleCharStream(stream, 1, 1);
    token_source = new flowppTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 3; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 3; i++) jj_la1[i] = -1;
  }

  /** Constructor with generated Token Manager. */
  public flowpp(flowppTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 3; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(flowppTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 3; i++) jj_la1[i] = -1;
  }

  private Token jj_consume_token(int kind) throws ParseException {
    Token oldToken;
    if ((oldToken = token).next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    if (token.kind == kind) {
      jj_gen++;
      return token;
    }
    token = oldToken;
    jj_kind = kind;
    throw generateParseException();
  }


/** Get the next Token. */
  final public Token getNextToken() {
    if (token.next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    jj_gen++;
    return token;
  }

/** Get the specific Token. */
  final public Token getToken(int index) {
    Token t = token;
    for (int i = 0; i < index; i++) {
      if (t.next != null) t = t.next;
      else t = t.next = token_source.getNextToken();
    }
    return t;
  }

  private int jj_ntk() {
    if ((jj_nt=token.next) == null)
      return (jj_ntk = (token.next=token_source.getNextToken()).kind);
    else
      return (jj_ntk = jj_nt.kind);
  }

  private java.util.List<int[]> jj_expentries = new java.util.ArrayList<int[]>();
  private int[] jj_expentry;
  private int jj_kind = -1;

  /** Generate ParseException. */
  public ParseException generateParseException() {
    jj_expentries.clear();
    boolean[] la1tokens = new boolean[23];
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 3; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 23; i++) {
      if (la1tokens[i]) {
        jj_expentry = new int[1];
        jj_expentry[0] = i;
        jj_expentries.add(jj_expentry);
      }
    }
    int[][] exptokseq = new int[jj_expentries.size()][];
    for (int i = 0; i < jj_expentries.size(); i++) {
      exptokseq[i] = jj_expentries.get(i);
    }
    return new ParseException(token, exptokseq, tokenImage);
  }

  /** Enable tracing. */
  final public void enable_tracing() {
  }

  /** Disable tracing. */
  final public void disable_tracing() {
  }

        }
