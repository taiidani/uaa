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
          "traefik.http.routers.uaa.rule=Host(`uaa.ryannixon.com`)",
          "traefik.http.routers.uaa.middlewares=uaa@consulcatalog",
          "traefik.http.routers.uaa.rule=Host(`uaa.ryannixon.com`)",
          "traefik.http.routers.uaa.tls=true",
          "traefik.http.routers.uaa.tls.certresolver=le",
          "traefik.http.middlewares.uaa.redirectscheme.scheme=https",
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
