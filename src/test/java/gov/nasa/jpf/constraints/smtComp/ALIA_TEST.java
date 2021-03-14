package gov.nasa.jpf.constraints.smtComp;

import gov.nasa.jpf.constraints.api.ConstraintSolver;
import gov.nasa.jpf.constraints.api.Valuation;
import gov.nasa.jpf.constraints.smtlibUtility.SMTProblem;
import gov.nasa.jpf.constraints.smtlibUtility.parser.SMTLIBParserException;
import gov.nasa.jpf.constraints.smtlibUtility.parser.utility.ResourceParsingHelper;
import gov.nasa.jpf.constraints.solvers.nativez3.NativeZ3Solver;
import org.smtlib.IParser;
import org.testng.annotations.Test;

import java.io.IOException;

import static gov.nasa.jpf.constraints.api.ConstraintSolver.Result.SAT;
import static org.testng.Assert.assertEquals;

public class ALIA_TEST {

    @Test
    public void run0f7c6a() throws SMTLIBParserException, IParser.ParserException, IOException {

        final SMTProblem problem = ResourceParsingHelper.parseResourceFile("test_inputs/ALIA/piVC_0f7c6a.smt2");
        final NativeZ3Solver solver = new NativeZ3Solver();
        final Valuation val = new Valuation();
        final ConstraintSolver.Result res = solver.solve(problem.getAllAssertionsAsConjunction(), val);
        assertEquals(res, SAT);
    }
}
