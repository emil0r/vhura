(ns vhura.client)


(defn get-id [client]
  (.getClientId client))

(defn set-id [client id]
  (.setClientId client (int id))
  client)


(defn get-key [client]
  (.getClientKey client))

(defn set-key [client key]
  (.setClientKey client key)
  client)


(defn set-sync [client sync]
  (.setSync client (int sync))
  client)

(defn get-wsapi-urls [client]
  (vec (.getWsapiUrls client)))

(defn set-wsapi-urls [client urls]
  (.setWsapiUrls client (java.util.ArrayList. urls)))

(defn set-useragent [client useragent]
  (.setUserAgent client useragent)
  client)

(defn get-public-id [client otp]
  (.getPublicId client otp))

(defn valid-otp-format? [client otp]
  (.isValidOTPFormat client otp))
