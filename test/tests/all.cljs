(ns tests.all
  (:require
    [cljs-time.core :as t]
    [cljs.test :refer [deftest is testing run-tests async use-fixtures]]
    [district.time :as time]))

(deftest tests
  (is (= {:seconds 40 :minutes 6 :hours 15 :days 4} (time/time-units 400000000)))

  (is (= [:days 4] (time/biggest-time-unit (time/time-units 400000000))))

  (is (= {:seconds 0 :minutes 0 :hours 3 :days 0} (time/time-remaining (t/now) (t/plus (t/now) (t/hours 3)))))

  (is (= [:hours 3] (time/time-remaining-biggest-unit (t/now) (t/plus (t/now) (t/hours 3)))))

  (is (= 1516314507000 (time/epoch->long 1516314507)))

  (is (= 1516314507 (time/long->epoch 1516314507000)))

  (is (= 259200 (time/days->seconds 3)))

  (is (= 4 (time/seconds->days 345600))))




