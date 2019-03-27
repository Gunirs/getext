# getext

This module enhances the macro keybind by adding new commands.
API version: 16 (for minecraft 1.7.10)

# requirements
 * LiteLoader
 * Macro KeyBind v0.10.12
 * Forge

# build
To build a project, run the `gradlew build` command. The result will be in the `build/libs` folder.
If you are not going to edit the source code, you can simply download the module in [.jar](https://github.com/jgunirs/getext/releases) format.

# commands
 * GETPLAYERPOS(<&player>,[&posX],[&posY],[&posZ],[&distance],[&pitch],[&yaw]) - Get a player position.
 * GETPLAYERINFO(<&player>,[&health],[&food],[&air],[&burn],[&armorVisibility],[&isSprint],[&speed],[&isInvis]) - Get player information.
 * GETPLAYERARMOR(<&player>,[&helmet],[&chestplate],[&leggings],[&boots]) - Get player armor.
 * CURRENTITEM(<&player>,[&itemID],[&displayName],[&damage],[&isEnchanted]) - Get information about the item in hand.<br>
 <b>The radius in which you can receive information may be limited by the server</b>
 
 * GETMEMORY(<command>,[#output]) - Get data about RAM.<br>
    <b>commands:</b>
      - [max] > Get maximum RAM.
      - [total] > Receive total RAM.
      - [free] > Get free RAM.
      - [used] > Get used RAM
