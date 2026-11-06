# ----------------------------------------------------------------------------- #

                    # Custom Dimension Portals Data Pack #
                        # Made by WafflesAreBetter #
                # https://www.youtube.com/c/WafflesAreBetter #

# This function checks if there's a complete nether portal shaped portal frame! #

# ----------------------------------------------------------------------------- #

                             # Look for a frame #

# ----------------------------------------------------------------------------- #

## Check in case the portal was activated on the botom block of the frame

# North
execute if block ~ ~-1 ~ #re8portals:frame/re8_dimension if block ~ ~-1 ~1 #re8portals:frame/re8_dimension if block ~ ~ ~-1 #re8portals:frame/re8_dimension if block ~ ~ ~2 #re8portals:frame/re8_dimension if block ~ ~1 ~-1 #re8portals:frame/re8_dimension if block ~ ~1 ~2 #re8portals:frame/re8_dimension if block ~ ~2 ~-1 #re8portals:frame/re8_dimension if block ~ ~2 ~2 #re8portals:frame/re8_dimension if block ~ ~3 ~ #re8portals:frame/re8_dimension if block ~ ~3 ~1 #re8portals:frame/re8_dimension if block ~ ~ ~1 #re8portals:air if block ~ ~1 ~ #re8portals:air if block ~ ~1 ~1 #re8portals:air if block ~ ~2 ~ #re8portals:air if block ~ ~2 ~1 #re8portals:air positioned ~ ~ ~ align xyz run function re8portals:activate/create/re8_dimension/z

# South
execute if block ~ ~-1 ~ #re8portals:frame/re8_dimension if block ~ ~-1 ~-1 #re8portals:frame/re8_dimension if block ~ ~ ~-2 #re8portals:frame/re8_dimension if block ~ ~ ~1 #re8portals:frame/re8_dimension if block ~ ~1 ~-2 #re8portals:frame/re8_dimension if block ~ ~1 ~1 #re8portals:frame/re8_dimension if block ~ ~2 ~-2 #re8portals:frame/re8_dimension if block ~ ~2 ~1 #re8portals:frame/re8_dimension if block ~ ~3 ~ #re8portals:frame/re8_dimension if block ~ ~3 ~-1 #re8portals:frame/re8_dimension if block ~ ~ ~-1 #re8portals:air if block ~ ~1 ~ #re8portals:air if block ~ ~1 ~-1 #re8portals:air if block ~ ~2 ~ #re8portals:air if block ~ ~2 ~-1 #re8portals:air positioned ~ ~ ~-1 align xyz run function re8portals:activate/create/re8_dimension/z

# East
execute if block ~ ~-1 ~ #re8portals:frame/re8_dimension if block ~-1 ~-1 ~ #re8portals:frame/re8_dimension if block ~1 ~ ~ #re8portals:frame/re8_dimension if block ~-2 ~ ~ #re8portals:frame/re8_dimension if block ~1 ~1 ~ #re8portals:frame/re8_dimension if block ~-2 ~1 ~ #re8portals:frame/re8_dimension if block ~1 ~2 ~ #re8portals:frame/re8_dimension if block ~-2 ~2 ~ #re8portals:frame/re8_dimension if block ~ ~3 ~ #re8portals:frame/re8_dimension if block ~-1 ~3 ~ #re8portals:frame/re8_dimension if block ~-1 ~ ~ #re8portals:air if block ~ ~1 ~ #re8portals:air if block ~-1 ~1 ~ #re8portals:air if block ~ ~2 ~ #re8portals:air if block ~-1 ~2 ~ #re8portals:air positioned ~-1 ~ ~ align xyz run function re8portals:activate/create/re8_dimension/x

# West
execute if block ~ ~-1 ~ #re8portals:frame/re8_dimension if block ~1 ~-1 ~ #re8portals:frame/re8_dimension if block ~2 ~ ~ #re8portals:frame/re8_dimension if block ~-1 ~ ~ #re8portals:frame/re8_dimension if block ~2 ~1 ~ #re8portals:frame/re8_dimension if block ~-1 ~1 ~ #re8portals:frame/re8_dimension if block ~2 ~2 ~ #re8portals:frame/re8_dimension if block ~-1 ~2 ~ #re8portals:frame/re8_dimension if block ~ ~3 ~ #re8portals:frame/re8_dimension if block ~1 ~3 ~ #re8portals:frame/re8_dimension if block ~1 ~ ~ #re8portals:air if block ~ ~1 ~ #re8portals:air if block ~1 ~1 ~ #re8portals:air if block ~ ~2 ~ #re8portals:air if block ~1 ~2 ~ #re8portals:air positioned ~ ~ ~ align xyz run function re8portals:activate/create/re8_dimension/x
