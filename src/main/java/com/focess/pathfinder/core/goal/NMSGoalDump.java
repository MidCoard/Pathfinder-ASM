package com.focess.pathfinder.core.goal;

import java.util.*;

import org.objectweb.asm.*;

public class NMSGoalDump implements Opcodes {

    public static byte[] dump() throws Exception {

        ClassWriter cw = new ClassWriter(0);
        FieldVisitor fv;
        MethodVisitor mv;
        AnnotationVisitor av0;

        cw.visit(52, ACC_PUBLIC + ACC_SUPER, "com/focess/pathfinder/core/goal/NMSGoal", null, "net/minecraft/server/v1_13_R1/PathfinderGoal", null);

        {
            fv = cw.visitField(ACC_PRIVATE + ACC_FINAL, "goal", "Lcom/focess/pathfinder/goal/Goal;", null, null);
            fv.visitEnd();
        }
        {
            mv = cw.visitMethod(ACC_PUBLIC, "<init>", "(Lcom/focess/pathfinder/goal/Goal;)V", null, null);
            mv.visitCode();
            mv.visitVarInsn(ALOAD, 0);
            mv.visitMethodInsn(INVOKESPECIAL, "net/minecraft/server/v1_13_R1/PathfinderGoal", "<init>", "()V", false);
            mv.visitVarInsn(ALOAD, 0);
            mv.visitVarInsn(ALOAD, 1);
            mv.visitFieldInsn(PUTFIELD, "com/focess/pathfinder/core/goal/NMSGoal", "goal", "Lcom/focess/pathfinder/goal/Goal;");
            mv.visitInsn(RETURN);
            mv.visitMaxs(2, 2);
            mv.visitEnd();
        }
        {
            mv = cw.visitMethod(ACC_PUBLIC, "a", "()Z", null, null);
            mv.visitCode();
            mv.visitVarInsn(ALOAD, 0);
            mv.visitFieldInsn(GETFIELD, "com/focess/pathfinder/core/goal/NMSGoal", "goal", "Lcom/focess/pathfinder/goal/Goal;");
            mv.visitMethodInsn(INVOKEVIRTUAL, "com/focess/pathfinder/goal/Goal", "canStart", "()Z", false);
            mv.visitInsn(IRETURN);
            mv.visitMaxs(1, 1);
            mv.visitEnd();
        }
        cw.visitEnd();

        return cw.toByteArray();
    }
}
