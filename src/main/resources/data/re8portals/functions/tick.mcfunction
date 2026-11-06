# ----------------------------------------------------------------------------- #

                    # Custom Dimension Portals Data Pack #
                        # Made by WafflesAreBetter #
                # https://www.youtube.com/c/WafflesAreBetter #

             # This funtion runs every tick! (20 times a second) #

# ----------------------------------------------------------------------------- #

# Check if the player used what's needed to activate the portal

scoreboard players set @a player_reach_range 13


execute as @a[scores={re8_dimension_portal_activation_check=1..},predicate=re8portals:dimensions/overworld] at @s rotated as @s anchored eyes run function re8portals:activate/locate_block/re8_dimension
execute as @a[scores={re8_dimension_portal_activation_check=1..},predicate=re8portals:dimensions/re8_dimension] at @s rotated as @s anchored eyes run function re8portals:activate/locate_block/re8_dimension

scoreboard players set @a re8_dimension_portal_activation_check 0

function re8portals:run/main/re8_dimension

execute as @e[predicate=re8portals:travellers/all_mobs] unless score @s re8portals_cooldown = @s re8portals_cooldown run scoreboard players set @s re8portals_cooldown 0
execute as @e[predicate=re8portals:travellers/all_mobs,scores={re8portals_cooldown=1..}] unless entity @e[type=armor_stand,tag=re8portals_portal_stand,distance=...5] run scoreboard players remove @s re8portals_cooldown 1
