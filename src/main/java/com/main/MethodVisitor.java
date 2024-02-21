package com.main;

import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;

class MethodVisitor extends VoidVisitorAdapter<Void> {
    private String methodNames;
    @Override
    public void visit(MethodDeclaration n, Void arg) {
        if (this.methodNames == null) {
            this.methodNames = n.getNameAsString();
        } else {
            this.methodNames += ", " + n.getNameAsString();
        }
        super.visit(n, arg);
    }

    String getMethodNames() {
        return this.methodNames;
    }
}
