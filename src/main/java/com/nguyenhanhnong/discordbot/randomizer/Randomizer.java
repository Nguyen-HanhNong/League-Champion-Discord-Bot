package com.nguyenhanhnong.discordbot.randomizer;

import com.merakianalytics.orianna.Orianna;
import com.merakianalytics.orianna.types.common.Region;
import com.merakianalytics.orianna.types.core.staticdata.Champion;
import com.merakianalytics.orianna.types.core.staticdata.Champions;

import com.merakianalytics.orianna.types.core.staticdata.Item;
import com.merakianalytics.orianna.types.core.staticdata.Items;
import io.github.cdimascio.dotenv.Dotenv;

import java.util.Random;

public class Randomizer {
    private final Champions allChampions = Champions.withRegion(Region.NORTH_AMERICA).get();
    private final String[] allRoles = {"Top", "Jungle", "Middle", "Bottom", "Support"};

    private final Items allItems = Items.withRegion(Region.NORTH_AMERICA).get();

    public Champions getAllChampions() {
        return allChampions;
    }

    public String[] getAllRoles() {
        return allRoles;
    }

    public Items getAllItems() {
        return allItems;
    }

    public Champion randomizedChampion() {
        int randomChampion = (int) (Math.random() * allChampions.size());
        return allChampions.get(randomChampion);
    }

    public String randomizedRole() {
        int randomRole = (int) (Math.random() * allRoles.length);
        return allRoles[randomRole];
    }

    public String randomizedFullBuild() {
        int[] ints;

        while(true) {
            boolean isFullBuild = false;
            ints = new Random().ints(0, allItems.size()).distinct().limit(6).toArray();

            for(Integer index: ints) {
                if(allItems.get(index).getName().contains("Boots")) {
                    isFullBuild = true;
                }
            }

            if(isFullBuild) {
                break;
            }
        }
        StringBuilder returnString = new StringBuilder();

        for(int i = 0; i < 6; i++) {
            int randomItemIndex = ints[i];
            returnString.append(allItems.get(randomItemIndex).getName()).append("\n");
        }

        return returnString.toString();
    }

    public Randomizer() {
        Orianna.setRiotAPIKey(Dotenv.configure().ignoreIfMalformed().load().get("RIOT_API_KEY"));
        Orianna.setDefaultRegion(Region.NORTH_AMERICA);
    }
}
