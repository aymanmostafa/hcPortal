/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, async } from '@angular/core/testing';
import { Observable } from 'rxjs/Observable';
import { HttpHeaders, HttpResponse } from '@angular/common/http';

import { HcPortalTestModule } from '../../../test.module';
import { VsHeartRateComponent } from '../../../../../../main/webapp/app/entities/vs-heart-rate/vs-heart-rate.component';
import { VsHeartRateService } from '../../../../../../main/webapp/app/entities/vs-heart-rate/vs-heart-rate.service';
import { VsHeartRate } from '../../../../../../main/webapp/app/entities/vs-heart-rate/vs-heart-rate.model';

describe('Component Tests', () => {

    describe('VsHeartRate Management Component', () => {
        let comp: VsHeartRateComponent;
        let fixture: ComponentFixture<VsHeartRateComponent>;
        let service: VsHeartRateService;

        beforeEach(async(() => {
            TestBed.configureTestingModule({
                imports: [HcPortalTestModule],
                declarations: [VsHeartRateComponent],
                providers: [
                    VsHeartRateService
                ]
            })
            .overrideTemplate(VsHeartRateComponent, '')
            .compileComponents();
        }));

        beforeEach(() => {
            fixture = TestBed.createComponent(VsHeartRateComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(VsHeartRateService);
        });

        describe('OnInit', () => {
            it('Should call load all on init', () => {
                // GIVEN
                const headers = new HttpHeaders().append('link', 'link;link');
                spyOn(service, 'query').and.returnValue(Observable.of(new HttpResponse({
                    body: [new VsHeartRate('123')],
                    headers
                })));

                // WHEN
                comp.ngOnInit();

                // THEN
                expect(service.query).toHaveBeenCalled();
                expect(comp.vsHeartRates[0]).toEqual(jasmine.objectContaining({id: '123'}));
            });
        });
    });

});
