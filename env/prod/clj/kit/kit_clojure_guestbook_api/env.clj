(ns kit.kit-clojure-guestbook-api.env
  (:require [clojure.tools.logging :as log]))

(def defaults
  {:init       (fn []
                 (log/info "\n-=[kit_clojure_guestbook_api starting]=-"))
   :start      (fn []
                 (log/info "\n-=[kit_clojure_guestbook_api started successfully]=-"))
   :stop       (fn []
                 (log/info "\n-=[kit_clojure_guestbook_api has shut down successfully]=-"))
   :middleware (fn [handler _] handler)
   :opts       {:profile :prod}})
