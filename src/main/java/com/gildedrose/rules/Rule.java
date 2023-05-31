package com.gildedrose.rules;

import com.gildedrose.Item;

public interface Rule {

    boolean matches(Item item);

    int qualityImpact(Item item);
}
