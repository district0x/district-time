# district-time

[![Build Status](https://travis-ci.org/district0x/district-time.svg?branch=master)](https://travis-ci.org/district0x/district-time)


Set of functions helpful for working with time.  


## Installation
Add `[district0x/district-time "1.0.1"]` into your project.clj  
Include `[district.time]` in your CLJS file  

## API Overview
- [district.time](#districttime)
  - [time-units](#time-units)
  - [biggest-time-unit](#biggest-time-unit)
  - [time-remaining](#time-remaining)
  - [time-remaining-biggest-unit](#time-remaining-biggest-unit)
  - [epoch->long](#epoch->long)
  - [long->epoch](#long->epoch)
  - [days->seconds](#days->seconds)
  - [seconds->days](#seconds->days)
  

## district.time
#### <a name="time-units">`time-units [milis]`
Divides given miliseconds into seconds, minutes, hours, days. 
```clojure
(time/time-units 400000000)
;; => {:seconds 40 :minutes 6 :hours 15 :days 4}
```

#### <a name="biggest-time-unit">`biggest-time-unit [{:keys [:seconds :minutes :hours :days]}]`
Returns biggest positive time unit from given parameters.
```clojure
(time/biggest-time-unit (time/time-units 400000000))
;; => [:days 4]
```

#### <a name="time-remaining">`time-remaining [from-time to-time]`
Time remaining from `from-time` to `to-time`. Passed times are from [cljs-time](https://github.com/andrewmcveigh/cljs-time) format.
```clojure
(time/time-remaining (t/now) (t/plus (t/now) (t/hours 3)))
;; => {:seconds 0 :minutes 0 :hours 3 :days 0}
```

#### <a name="time-remaining-biggest-unit">`time-remaining-biggest-unit [from-time to-time]`
Returns biggest time unit from remaining time. Passed times are from [cljs-time](https://github.com/andrewmcveigh/cljs-time) format.
```clojure
(time/time-remaining-biggest-unit (t/now) (t/plus (t/now) (t/hours 3)))
;; => [:hours 3]
```

#### <a name="epoch->long">`epoch->long [x]`
Converts epoch to long time format.
```clojure
(time/epoch->long 1516314507)
;; => 1516314507000
```

#### <a name="long->epoch">`long->epoch [x]`
Converts long to epoch time format.
```clojure
(time/long->epoch 1516314507000)
;; => 1516314507
```

#### <a name="days->seconds">`days->seconds [x]`
Converts days to seconds.
```clojure
(time/days->seconds 3)
;; => 259200
```

#### <a name="seconds->days">`seconds->days [x]`
Converts seconds to days.
```clojure
(time/seconds->days 345600)
;; => 259200
```

## Development
```bash
lein deps
# To run tests and rerun on changes
lein doo chrome tests
```