package com.nguyenhanhnong.discordbot.randomizer;

import com.merakianalytics.orianna.Orianna;
import com.merakianalytics.orianna.types.common.Queue;
import com.merakianalytics.orianna.types.common.Region;
import com.merakianalytics.orianna.types.common.Role;
import com.merakianalytics.orianna.types.core.league.League;
import com.merakianalytics.orianna.types.core.staticdata.Champion;
import com.merakianalytics.orianna.types.core.staticdata.Champions;
import com.merakianalytics.orianna.types.core.summoner.Summoner;

import io.github.cdimascio.dotenv.Dotenv;

public class Randomizer {
    Champions allChampions;
    private final String[] allRoles = {"TOP", "JUNGLE", "MIDDLE", "BOTTOM", "SUPPORT"};

    public Champions getAllChampions() {
        return allChampions;
    }

    public String[] getAllRoles() {
        return allRoles;
    }

    public Champion randomizedChampion() {
        int randomChampion = (int) (Math.random() * allChampions.size());
        return allChampions.get(randomChampion);
    }

    public String randomizedRole() {
        int randomRole = (int) (Math.random() * allRoles.length);
        return allRoles[randomRole];
    }

    public Randomizer() {
        Orianna.setRiotAPIKey(Dotenv.configure().ignoreIfMalformed().load().get("RIOT_API_KEY"));
        Orianna.setDefaultRegion(Region.NORTH_AMERICA);

        allChampions = Champions.withRegion(Region.NORTH_AMERICA).get();
    }
}
