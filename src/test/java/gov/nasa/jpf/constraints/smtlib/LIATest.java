package gov.nasa.jpf.constraints.smtlib;

import static org.testng.AssertJUnit.assertEquals;

import gov.nasa.jpf.constraints.api.ConstraintSolver;
import gov.nasa.jpf.constraints.api.ConstraintSolver.Result;
import gov.nasa.jpf.constraints.api.Expression;
import gov.nasa.jpf.constraints.api.Valuation;
import gov.nasa.jpf.constraints.smtlibUtility.SMTProblem;
import gov.nasa.jpf.constraints.smtlibUtility.parser.SMTLIBParserException;
import gov.nasa.jpf.constraints.solvers.nativez3.NativeZ3Solver;
import java.io.IOException;
import java.net.URISyntaxException;
import org.smtlib.IParser.ParserException;
import org.testng.annotations.Test;

public class LIATest {

  @Test
  public void LIAPsyco014Test()
      throws SMTLIBParserException, IOException, ParserException, URISyntaxException {
    SMTProblem problem = LoadingUtil.loadProblemFromResources("psyco/014.smt2");
    NativeZ3Solver solver = new NativeZ3Solver();
    Valuation model = new Valuation();
    //assertEquals(2, problem.assertions.size());
    Expression<Boolean> expr = problem.getAllAssertionsAsConjunction();
    System.out.println(expr.toString());

    ConstraintSolver.Result jRes = solver.solve(expr, model);
    assertEquals(ConstraintSolver.Result.UNSAT, jRes);
  }

  @Test
  public void LIAPsyco070Test()
      throws SMTLIBParserException, IOException, ParserException, URISyntaxException {
    SMTProblem problem = LoadingUtil.loadProblemFromResources("psyco/070.smt2");
    NativeZ3Solver solver = new NativeZ3Solver();
    Valuation model = new Valuation();
    Expression<Boolean> expr = problem.getAllAssertionsAsConjunction();
    ConstraintSolver.Result jRes = solver.solve(expr, model);
    assertEquals(jRes, ConstraintSolver.Result.UNSAT);
  }

  @Test
  public void LIAPsyco160Test()
      throws SMTLIBParserException, IOException, ParserException, URISyntaxException {
    SMTProblem problem = LoadingUtil.loadProblemFromResources("psyco/160.smt2");
    NativeZ3Solver solver = new NativeZ3Solver();
    Valuation model = new Valuation();
    Expression<Boolean> expr = problem.getAllAssertionsAsConjunction();
    ConstraintSolver.Result jRes = solver.solve(expr, model);
    assertEquals(ConstraintSolver.Result.UNSAT, jRes);
  }

  @Test
  public void LIAPsyco167Test()
      throws SMTLIBParserException, IOException, ParserException, URISyntaxException {
    SMTProblem problem = LoadingUtil.loadProblemFromResources("psyco/167.smt2");
    NativeZ3Solver solver = new NativeZ3Solver();
    Valuation model = new Valuation();
    Expression<Boolean> expr = problem.getAllAssertionsAsConjunction();
    ConstraintSolver.Result jRes = solver.solve(expr, model);
    assertEquals(ConstraintSolver.Result.UNSAT, jRes);
  }

  @Test
  public void LIAPsyco170Test()
      throws SMTLIBParserException, IOException, ParserException, URISyntaxException {
    SMTProblem problem = LoadingUtil.loadProblemFromResources("psyco/170.smt2");
    NativeZ3Solver solver = new NativeZ3Solver();
    Valuation model = new Valuation();
    Expression<Boolean> expr = problem.getAllAssertionsAsConjunction();
    ConstraintSolver.Result jRes = solver.solve(expr, model);
    assertEquals(ConstraintSolver.Result.SAT, jRes);
  }

  @Test
  public void automizer01Test()
      throws SMTLIBParserException, IOException, ParserException, URISyntaxException {
    SMTProblem problem = LoadingUtil
        .loadProblemFromResources("Problem15_label00_false-unreach-call.c_5.smt2");
    NativeZ3Solver solver = new NativeZ3Solver();
    Valuation model = new Valuation();
    Expression<Boolean> expr = problem.getAllAssertionsAsConjunction();
    ConstraintSolver.Result jRes = solver.solve(expr, model);
    assertEquals(Result.DONT_KNOW, jRes);
  }

  @Test
  public void automizer02Test()
      throws SMTLIBParserException, IOException, ParserException, URISyntaxException {
    SMTProblem problem = LoadingUtil
        .loadProblemFromResources("Problem18_label34_false-unreach-call.c_10.smt2");
    NativeZ3Solver solver = new NativeZ3Solver();
    Valuation model = new Valuation();
    Expression<Boolean> expr = problem.getAllAssertionsAsConjunction();
    ConstraintSolver.Result jRes = solver.solve(expr, model);
    assertEquals(Result.SAT, jRes);
  }

  @Test(enabled = false)
  public void automizer03Test()
      throws SMTLIBParserException, IOException, ParserException, URISyntaxException {
    SMTProblem problem = LoadingUtil
        .loadProblemFromResources("Problem18_label34_false-unreach-call.c_12.smt2");
    NativeZ3Solver solver = new NativeZ3Solver();
    Valuation model = new Valuation();
    Expression<Boolean> expr = problem.getAllAssertionsAsConjunction();
    ConstraintSolver.Result jRes = solver.solve(expr, model);
    assertEquals(Result.SAT, jRes);
  }

  @Test
  public void tptp01Test()
      throws SMTLIBParserException, IOException, ParserException, URISyntaxException {
    SMTProblem problem = LoadingUtil
        .loadProblemFromResources("NUM916_1.smt2");
    NativeZ3Solver solver = new NativeZ3Solver();
    Valuation model = new Valuation();
    Expression<Boolean> expr = problem.getAllAssertionsAsConjunction();
    ConstraintSolver.Result jRes = solver.solve(expr, model);
    assertEquals(Result.UNSAT, jRes);
  }

  @Test
  public void tptp02Test()
      throws SMTLIBParserException, IOException, ParserException, URISyntaxException {
    SMTProblem problem = LoadingUtil
        .loadProblemFromResources("ARI5901.smt2");
    NativeZ3Solver solver = new NativeZ3Solver();
    Valuation model = new Valuation();
    Expression<Boolean> expr = problem.getAllAssertionsAsConjunction();
    ConstraintSolver.Result jRes = solver.solve(expr, model);
    assertEquals(Result.UNSAT, jRes);
  }
}
