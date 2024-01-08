package dev.mardroide.fireworksmechanics.recipes;

import dev.mardroide.fireworksmechanics.FireworksMechanics;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

public class ReinforcedFirework {
    public ReinforcedFirework() {
        ItemStack firework = new ItemStack(Material.FIREWORK_ROCKET);
        ItemMeta fireworkMeta = firework.getItemMeta();
        fireworkMeta.setDisplayName(ChatColor.YELLOW + "Reinforced firework");
        fireworkMeta.addEnchant(Enchantment.LUCK, 1, false);
        fireworkMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        firework.setItemMeta(fireworkMeta);

        NamespacedKey key = new NamespacedKey(FireworksMechanics.getInstance(), "reinforced_firework");
        ShapedRecipe reinforceRocketRecipe = new ShapedRecipe(key, firework);

        reinforceRocketRecipe.shape("XXX", "XYX", "XXX");
        reinforceRocketRecipe.setIngredient('X', Material.PAPER);
        reinforceRocketRecipe.setIngredient('Y', Material.FIREWORK_ROCKET);

        Bukkit.addRecipe(reinforceRocketRecipe);
    }
}
