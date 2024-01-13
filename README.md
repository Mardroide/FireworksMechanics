<img style="border-radius: 10px;" src="https://imgur.com/Un7Ennk.png" alt="FireworkMechanics" />

# FireworksMechanics ![GitHub Release](https://img.shields.io/github/v/release/sphealhub/FireworksMechanics)

Revolutionize your Minecraft experience with our SpigotMC plugin that introduces dynamic explosive mechanics to fireworks and dynamites. Unleash the chaos as explosive artifacts now have the thrilling possibility of failure, adding an unpredictable twist to your in-game pyrotechnic displays. Elevate your gameplay and download now for an explosive adventure like never before!

### Commands
- `/fmreload` reload the plugin configuration.

### Permissions
- `fireworksmechanics.reload`

### Configuration File
```yml
# Configuration file, v1.0.0-alpha.
# All fields represent a percentage 0 - 100 (%).
# For better experience set between 1 - 15.

fireworks:
  explode-fail-rate: 10 # How frequently should fireworks fail and don't work.
  boost-fail-rate: 10 # How frequently should fireworks fail (reduce boost) when use elytra.

dynamite:
  reduce-fire-ticks: true # Reduce the waiting time till the dynamite explode.
  fire-ticks-seconds: 3 # Amount of seconds for the tnt to explode.

  drop-dynamite: true # Dropping the item on explosion failure.
  explode-fail-rate: 100  # How frequently should dynamite fail and don't explode.
```

# Preview

https://github.com/sphealhub/FireworksMechanics/assets/83825951/da826be0-4e2a-42d0-8db1-373c3d4c5d12
