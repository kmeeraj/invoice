package com.abiola.abiola.strategy;

public class DefaultTax implements ITax{
    @Override
    public float getTax() {
        return 0.1f;
    }
}
