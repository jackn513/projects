from django.urls import path
from . import views


urlpatterns = [
    path('', views.SingleSoil, name='soil_details'),
]