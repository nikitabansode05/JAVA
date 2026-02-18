package com.hospital.command.entity;

@FunctionalInterface
public interface Command{
    public abstract int execute(int a,int b);
}