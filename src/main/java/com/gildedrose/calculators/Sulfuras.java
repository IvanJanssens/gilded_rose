package com.gildedrose.calculators;

import com.gildedrose.Item;
import com.gildedrose.rules.Rule;

import java.util.Collections;
import java.util.List;

public class Sulfuras implements GildedRoseCalculator {

    @Override
    public List<Rule> getRules() {
        return Collections.emptyList();
    }

    @Override
    public void updateSellIn(Item item) {
        //noOp
    }
}
