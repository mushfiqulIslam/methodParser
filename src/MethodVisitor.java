import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;

class MethodVisitor extends VoidVisitorAdapter<Void> {
    private boolean visitingFirstTime = true;
    @Override
    public void visit(MethodDeclaration n, Void arg) {
        if (this.visitingFirstTime) {
            System.out.println();
            System.out.print(n.getNameAsString());
            this.visitingFirstTime = false;
        } else {
            System.out.print(", "+ n.getNameAsString());
        }
        super.visit(n, arg);
    }
}
