/*
 *   Copyright (C) 2016 GeorgH93
 *
 *   This program is free software: you can redistribute it and/or modify
 *   it under the terms of the GNU General Public License as published by
 *   the Free Software Foundation, either version 3 of the License, or
 *   (at your option) any later version.
 *
 *   This program is distributed in the hope that it will be useful,
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 *   GNU General Public License for more details.
 *
 *   You should have received a copy of the GNU General Public License
 *   along with this program. If not, see <http://www.gnu.org/licenses/>.
 */

package at.pcgamingfreaks.MarriageMaster.Bukkit.Placeholder.Replacer;

import at.pcgamingfreaks.MarriageMaster.Bukkit.API.Marriage;
import at.pcgamingfreaks.MarriageMaster.Bukkit.API.MarriagePlayer;
import at.pcgamingfreaks.MarriageMaster.Bukkit.MarriageMaster;

import org.bukkit.OfflinePlayer;

public class NearestHomeZ extends PlaceholderReplacerBase
{
	public NearestHomeZ(MarriageMaster plugin)
	{
		super(plugin);
	}

	@Override
	public String replace(OfflinePlayer player)
	{
		MarriagePlayer playerData = plugin.getPlayerData(player);
		if(playerData.isMarried())
		{
			Marriage marriageData = playerData.getNearestPartnerMarriageData();
			//noinspection ConstantConditions
			return marriageData.isHomeSet() ? marriageData.getHome().getLocation().getZ() + "" : valueNotMarried;
		}
		return null;
	}
}