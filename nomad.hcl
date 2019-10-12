job "uaa" {
  datacenters = ["do-sfo2"]
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
          "traefik.frontend.rule=Host: uaa.ryannixon.com",
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
