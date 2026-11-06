# ----------------------------------------------------------------------------- #

                    # Custom Dimension Portals Data Pack #
                        # Made by WafflesAreBetter #
                # https://www.youtube.com/c/WafflesAreBetter #

            # This function checks where the portal was activated! #

# ----------------------------------------------------------------------------- #

# Check where the block the player placed is

execute if block ~ ~ ~ #re8portals:activation/re8_dimension if block ~ ~-1 ~ #re8portals:frame/re8_dimension run function re8portals:activate/check_frame/re8_dimension/bottom
execute if block ~ ~ ~ #re8portals:activation/re8_dimension if block ~ ~-2 ~ #re8portals:frame/re8_dimension run function re8portals:activate/check_frame/re8_dimension/mid
execute if block ~ ~ ~ #re8portals:activation/re8_dimension if block ~ ~-3 ~ #re8portals:frame/re8_dimension run function re8portals:activate/check_frame/re8_dimension/top
scoreboard players remove @s player_reach_range 1
execute if score @s player_reach_range matches 1.. if block ~ ~ ~ #re8portals:air positioned ^ ^ ^0.5 run function re8portals:activate/locate_block/re8_dimension