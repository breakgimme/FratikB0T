/*
 * Copyright (C) 2019-2020 FratikB0T Contributors
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package pl.fratik.fratikcoiny.commands;

import org.jetbrains.annotations.NotNull;
import pl.fratik.core.cache.RedisCacheManager;
import pl.fratik.core.command.CommandContext;
import pl.fratik.core.entity.GuildConfig;
import pl.fratik.core.entity.GuildDao;
import pl.fratik.core.entity.MemberConfig;
import pl.fratik.core.entity.MemberDao;

public class KasaCommand extends CoinCommand {

    public KasaCommand(MemberDao memberDao, GuildDao guildDao, RedisCacheManager redisCacheManager) {
        super(memberDao, guildDao, redisCacheManager);
        name = "kasa";
        aliases = new String[] {"fc", "stan", "konto", "money", "pieniadzenakoncie", "stankonta", "mojstankonta", "mmojakasa"};
    }

    @Override
    public boolean execute(@NotNull CommandContext context) {
        GuildConfig.Moneta m = resolveMoneta(context);
        MemberConfig mc = memberDao.get(context.getMember());
        context.send(context.getTranslated("kasa.success", String.valueOf(mc.getKasa()), m.getShort(context)));
        return true;
    }
}
