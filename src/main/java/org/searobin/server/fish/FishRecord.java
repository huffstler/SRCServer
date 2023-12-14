package org.searobin.server.fish;

import org.searobin.server.tier.Tier;

public record FishRecord(
        int id,
        String name,
        Tier tier
) { }
