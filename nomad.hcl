job "uaa" {
  datacenters = ["pi"]
  type = "service"

  group "uaa" {
    task "web" {
      driver = "docker"

      config {
        image = "taiidani/uaa:latest"

        port_map {
          http = 80
        }
      }

      service {
        port = "http"
        tags = [
          "traefik.enable=true",
          "traefik.http.routers.http.rule=Host(`uaa.ryannixon.com`)",
          "traefik.http.routers.http.middlewares=redirect@consulcatalog",
          "traefik.http.routers.site.rule=Host(`uaa.ryannixon.com`)",
          "traefik.http.routers.site.tls=true",
          "traefik.http.routers.site.tls.certresolver=le",
          "traefik.http.middlewares.redirect.redirectscheme.scheme=https",
        ]
      }

      resources {
        network {
          port "http" {}
        }
      }
    }
  }
}
