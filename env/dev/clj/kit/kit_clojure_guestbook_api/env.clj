(ns kit.kit-clojure-guestbook-api.env
  (:require
    [clojure.tools.logging :as log]
    [kit.kit-clojure-guestbook-api.dev-middleware :refer [wrap-dev]]))

(def defaults
  {:init       (fn []
                 (log/info "\n-=[kit_clojure_guestbook_api starting using the development or test profile]=-"))
   :start      (fn []
                 (log/info "\n-=[kit_clojure_guestbook_api started successfully using the development or test profile]=-"))
   :stop       (fn []
                 (log/info "\n-=[kit_clojure_guestbook_api has shut down successfully]=-"))
   :middleware wrap-dev
   :opts       {:profile       :dev
                :persist-data? true}})
