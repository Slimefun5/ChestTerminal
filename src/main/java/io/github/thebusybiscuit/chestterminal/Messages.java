package io.github.thebusybiscuit.chestterminal;

import java.util.function.UnaryOperator;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import io.github.thebusybiscuit.slimefun5.implementation.Slimefun;

/**
 * Resolves this addon's chat text for one viewer, from {@code languages/<lang>/messages.yml}.
 *
 * @implNote The {@link ChatColor} deliberately stays at the call site rather than moving into the
 *           translated value: a translator never edits a colour code they cannot see the effect of.
 */
public final class Messages {

    private Messages() {}

    @Nonnull
    private static ChestTerminal addon() {
        return JavaPlugin.getPlugin(ChestTerminal.class);
    }

    @Nonnull
    public static String get(@Nullable Player player, @Nonnull String key, @Nonnull String english) {
        return Slimefun.getAddonMessageService().getMessage(player, addon(), key, english);
    }

    public static void send(@Nonnull CommandSender recipient, @Nonnull String key, @Nonnull String english) {
        Slimefun.getAddonMessageService().sendMessage(recipient, addon(), key, english);
    }

    public static void send(@Nonnull CommandSender recipient, @Nonnull ChatColor colour, @Nonnull String key, @Nonnull String english) {
        send(recipient, colour, key, english, UnaryOperator.identity());
    }

    public static void send(@Nonnull CommandSender recipient, @Nonnull ChatColor colour, @Nonnull String key,
                            @Nonnull String english, @Nonnull UnaryOperator<String> placeholders) {
        Slimefun.getAddonMessageService().sendMessage(recipient, addon(), key, english,
                line -> colour + placeholders.apply(line));
    }

    /**
     * The refusal shape the wireless terminals share: the word {@code Failed} in dark red, then the
     * reason in red.
     *
     * @implNote A composite rather than one key per full sentence, because the colour changes
     *           mid-line and the shared half would otherwise be retranslated five times.
     */
    public static void sendFailure(@Nonnull Player player, @Nonnull String key, @Nonnull String english) {
        player.sendMessage(ChatColor.DARK_RED + get(player, "terminal.failed", "Failed")
                + ChatColor.RED + " - " + get(player, key, english));
    }
}
